package com.wly.mianshi.设计模式.factory;

public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("mail send");
    }
}
