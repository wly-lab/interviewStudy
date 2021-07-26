package com.wly.mianshi.设计模式.observer;

public interface SubObject {
    //增加观察者
    public void add(Observer observer);
    //删除观察者
    public void delete(Observer observer);
    //通知所有观察者
    public void notifyObservers();
    //自身发生变化
    public void operation();
}
