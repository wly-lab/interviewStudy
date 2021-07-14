package com.wly.mianshi.设计模式.decorator;

/**
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例。
 */
public class Decorator implements Sourceable{
    private Sourceable sourceable;
    public Decorator(Sourceable sourceable){
        this.sourceable=sourceable;
    }


    @Override
    public void method1() {
        System.out.println("before");
        sourceable.method1();
        System.out.println("after");
    }

    public static void main(String[] args) {
        Source source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.method1();
    }
}
