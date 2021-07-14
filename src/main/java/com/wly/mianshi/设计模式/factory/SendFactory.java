package com.wly.mianshi.设计模式.factory;

/**
 * 普通工厂模式：普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 */
public class SendFactory {
    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new SMSSender();
        }else {
            System.out.println("请输入正确类型！");
            return null;
        }
    }
}
