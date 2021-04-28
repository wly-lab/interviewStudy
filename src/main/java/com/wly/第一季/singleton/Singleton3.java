package com.wly.第一季.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * 单例模式要点：
 * 1.某个类只能有一个实例
 *     --->构造器私有化
 * 2.必须自行创建这个实例
 *      -->含有一个该类的静态变量来保存这个唯一的实例
 * 3.必须自行向整个系统提供这个实例
 *     对外提供获取该实例对象的方法 --直接暴露、静态get
 */

//饿汉式
public class Singleton3 {
    /**
     * 1.构造器私有化
     * 2.自行创建 ，并且用静态变量保存
     * 3.向外提供这个实例
     */
    public static final Singleton3 INSTANCE;
    private  String info;
    static {
        Properties pro=new Properties();
        try {
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        INSTANCE=new Singleton3(pro.getProperty("info"));
    }
    private Singleton3(String info){
        this.info=info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
