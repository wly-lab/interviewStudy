package com.wly.atguigu.第一季.singleton;
/**
 * 单例模式要点：
 * 1.某个类只能有一个实例
 *     --->构造器私有化
 * 2.必须自行创建这个实例
 *      -->含有一个该类的静态变量来保存这个唯一的实例
 * 3.必须自行向整个系统提供这个实例
 *     对外提供获取该实例对象的方法 --直接暴露、静态get
 */

//懒汉式 加锁
public class Singleton5 {
    /**
     * 1.构造器私有化
     * 2.自行创建 ，并且用静态变量保存
     * 3.向外提供方法获取这个实例
     */
    private static Singleton5 instance;
    private Singleton5(){

    }
    public static Singleton5 getInstance(){
        synchronized (Singleton5.class){
            if (instance==null){
                instance=new Singleton5();
            }
            return instance;
        }

    }
}
