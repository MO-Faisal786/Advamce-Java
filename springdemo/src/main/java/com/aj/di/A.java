package com.aj.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    private B b;
    @Autowired
    private C c;

    public void m2() {
        System.out.println("m2() of C is executed...");
        this.b.m1();
        this.c.m1();
    }
}
