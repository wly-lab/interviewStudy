package com.wly.mianshi.设计模式.singleton;
//懒汉式：
public class Singleton2 {
    private static volatile   Singleton2 instance;
    private Singleton2(){

    }
    public Singleton2 getInstance(){
        if(instance==null){
            synchronized (Singleton2.class){
                if(instance==null){
                    instance=new Singleton2();
                }
            }
        }
        return instance;
    }

}
