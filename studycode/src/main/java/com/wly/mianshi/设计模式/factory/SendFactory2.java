package com.wly.mianshi.设计模式.factory;

/**
 * 多个工厂方法模式
 * 该模式是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而
 * 多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
public class SendFactory2 {
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SMSSender();
    }
}
