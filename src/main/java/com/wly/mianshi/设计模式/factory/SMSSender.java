package com.wly.mianshi.设计模式.factory;

public class SMSSender implements Sender {
    @Override
    public void send() {
        System.out.println("SMS Send");
    }
}
