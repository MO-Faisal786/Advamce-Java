package com.aj.DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aj.DTOs.AccountDetailsDTO;
import com.aj.user.User;

public class DB {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    AccountDetailsDTO accountDetailsDTO;
    private User user = new User();

    public DB() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = this.sessionFactory.openSession();
    }

    public boolean getStatus() {
        return user.getInput();
    }

    public boolean varifyUser() {
        Integer accNo = this.user.getAccNo();
        this.transaction = this.session.beginTransaction();
        accountDetailsDTO = this.session.get(AccountDetailsDTO.class, accNo);
        this.transaction.commit();
        if (accountDetailsDTO != null) {
            return true;
        }
        return false;

    }

    public void showDetails() {
        System.out.println("=============================================");
        System.out.println("Your account details...");
        System.out.println(this.accountDetailsDTO);
        Integer choice = this.user.getChoice();
        if (choice == 1) {
            this.transferMoney();
            this.showDetails();
        } else if (choice==2) {
            Double balance = this.user.getBal();
            this.credit(balance);
            this.showDetails();
        } else if (choice==3) {
            Double balance = this.user.getBal();
            this.withdraw(balance);
            this.showDetails();
        } else if (choice==4) {
            this.user.exit();
        } else {
            System.out.println("Please enter a valid input...");
            this.showDetails();
        }

    }

    public void createUser() {
        this.accountDetailsDTO = this.user.getUserData();
        this.transaction = this.session.beginTransaction();
        this.session.persist(this.accountDetailsDTO);
        this.transaction.commit();
        this.showDetails();
    }

    public void credit(Double balance){
        this.transaction = this.session.beginTransaction();
        this.accountDetailsDTO = this.session.get(AccountDetailsDTO.class, this.accountDetailsDTO.getAccountNumber());
        this.accountDetailsDTO.setAccountBalance(this.accountDetailsDTO.getAccountBalance()+balance);
        this.session.persist(this.accountDetailsDTO);
        this.transaction.commit();
        System.out.println("===========================================================================");
        System.out.println("Your balance is credited successfully...");
    }

    public void withdraw(Double balance){
        this.transaction = this.session.beginTransaction();
        this.accountDetailsDTO = this.session.get(AccountDetailsDTO.class, this.accountDetailsDTO.getAccountNumber());
        this.accountDetailsDTO.setAccountBalance(this.accountDetailsDTO.getAccountBalance()-balance);
        this.session.persist(this.accountDetailsDTO);
        this.transaction.commit();
        System.out.println("===================================================================");
        System.out.println("Your balance is withdraw successfully...");
    }

    public void transferMoney() {
        System.out.println("=======================================================================");
        System.out.println("Please enter account details...");
        Integer accNo = user.getAccNo();
        Double balance = user.getBal();
        this.transaction = this.session.beginTransaction();
        AccountDetailsDTO accountDetailsDTO = this.session.get(AccountDetailsDTO.class, accNo);
        Double accountBalance = accountDetailsDTO.getAccountBalance();
        accountDetailsDTO.setAccountBalance(accountBalance+balance);
        this.session.persist(accountDetailsDTO);

        accountBalance = this.accountDetailsDTO.getAccountBalance();
        this.accountDetailsDTO.setAccountBalance(accountBalance-balance);
        this.session.persist(this.accountDetailsDTO);
        this.transaction.commit();
        System.out.println("===========================================================");
        System.out.println("Transection has been done successfully...");
    }

    

    public void closeSession() {
        this.session.close();
        this.sessionFactory.close();
    }
}
