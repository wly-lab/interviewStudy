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

//懒汉式

/**
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，他是要单独加载和初始化的
 * 因为是在内部类加载和初始化时创建的，所以是线程安全的
 */
public class Singleton7 {
    /**
     * 1.构造器私有化
     * 2.自行创建 ，并且用静态变量保存
     * 3.向外提供方法获取这个实例
     */
    private Singleton7(){

    }
    private static class Inner{
        private  static final Singleton7 INSTANCE=new Singleton7();
    }

    public static  Singleton7 getInstance(){
        return  Inner.INSTANCE;
    }


}
