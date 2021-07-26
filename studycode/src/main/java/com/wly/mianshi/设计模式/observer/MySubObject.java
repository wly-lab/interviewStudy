package com.wly.mianshi.设计模式.observer;

/**
 * 观察者模式很好理解，类似于邮件订阅和 RSS 订阅，当我们浏览一些博客或 wiki 时，经常会看到 RSS 图标，就
 * 这的意思是，当你订阅了该文章，如果后续有更新，会及时通知你。其实，简单来讲就一句话：当一个对象变化时，其
 * 它依赖该对象的对象都会收到通知，并且随着变化！对象之间是一种一对多的关系。
 *
 * 观察者接口：通知自身的方法
 * 被观察者接口   包括增加 删除观察者、自身变更及通知观察者方法
 *
 * 被观察者抽象类 包含多个观察者 实现被观察者接口的方法 其中自身变更不实现 适配器模式   通知方法遍历其中所有观察者，调用每一个的通知方法
 *
 * 被观察者实现类继承被观察者抽象类 实现自身变更方法 自身变更方法内调用通知的方法
 *
 *
 */
public class MySubObject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

    public static void main(String[] args) {
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        MySubObject mySubObject = new MySubObject();
        mySubObject.add(observer1);
        mySubObject.add(observer2);
        mySubObject.operation();
    }
}
