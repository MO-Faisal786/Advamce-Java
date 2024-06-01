package com.aj.user;

import java.util.Scanner;

import com.aj.DTOs.AccountDetailsDTO;

public class User {

    public boolean getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.print("Do you have an account or not? Enter 'yes' or 'no': ");
        String status = sc.nextLine();
        if (status.equalsIgnoreCase("yes")) {
            return true;
        } else if (status.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            return getInput();
        }
    }

    public AccountDetailsDTO getUserData() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("==========================================");
        System.out.print("Enter your full name: ");
        String name = sc.nextLine();
        System.out.println("===================Account Type============");
        System.out.print("Enter 'saving' for saving or 'current' for current: ");
        String accountType = sc.nextLine();
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();
        accountDetailsDTO.setAccountHolderName(name);
        accountDetailsDTO.setAccountType(accountType);
        accountDetailsDTO.setAddress(address);
        return accountDetailsDTO;
    }

    public Integer getAccNo(){
        Scanner sc =new Scanner(System.in);
        System.out.println("========================================");
        System.out.print("Enter account number: ");
        Integer accNo = sc.nextInt();
        return accNo;
    }

    public Double getBal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================");
        System.out.println("Enter balance: ");
        Double balance = sc.nextDouble();
        return balance;
    }

    public Integer getChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("Do you want to do some action or exit?");
        System.out.print("Enter 1 for transfer ");
        System.out.print("      2 for credit ");
        System.out.print("      3 for withdraw ");
        System.out.println("    4 for exit");
        Integer choice = sc.nextInt();
        return choice;
    }

    public void exit(){
        System.out.println("============================================================================");
        System.out.println("Thank you for visiting our branch...");
        System.out.println("============================================================================");
    }
}
