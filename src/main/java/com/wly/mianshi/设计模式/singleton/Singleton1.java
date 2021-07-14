package com.wly.mianshi.设计模式.singleton;
//饿汉式：
public class Singleton1 {
    // 直接创建对象
    private static final Singleton1 INSTANCE=new Singleton1();
    //私有化构造函数
    private Singleton1(){

    }
    // 返回对象实例
    public Singleton1 getInstance(){
        return INSTANCE;
    }
}
