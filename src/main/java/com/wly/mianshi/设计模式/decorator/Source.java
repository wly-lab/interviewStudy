package com.wly.mianshi.设计模式.decorator;

public class Source implements Sourceable {
    @Override
    public void method1() {
        System.out.println("this is the original method");
    }
}
