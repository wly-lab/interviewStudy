package com.wly.atguigu.第二季.com.wly;

public class SingletonDemo {
    //初始化时由于指令重排，可能获取到空的对象 存在线程安全问题
    private  static  volatile SingletonDemo instance=null;

    private SingletonDemo(){
        System.out.println("构造方法");
    }
    //DCL (Double Check Lock) 双端检锁机制
    private  static SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance=new SingletonDemo();
                }

            }
        }
        return instance;
    }
    public static void main(String[] args) {

    }
}
