package com.module3;

import com.module1.A;

public class B {

    public void greeting(){
        A a = new A();
        System.out.println("Greeting from B");
        a.greeting();
    }
}
