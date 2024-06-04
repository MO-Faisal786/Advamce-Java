package com.aj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aj.di.A;
import com.aj.di.Car;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");
        // Demo demo = context.getBean(Demo.class);
        // System.out.println(demo);

        // Car car = context.getBean(Car.class);
        // car.getEngine().start();

        A a = context.getBean(A.class);
        a.m2();
    }
}
