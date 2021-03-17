package com.wly.atguigu.first.类初始化和实例初始化;


/**
 * 父类初始化 <clinit>
 * 1、j = method()
 * 2、父类的静态代码块
 *
 * 父类实例化方法:
 * 1、super()（最前）
 * 2、i = test() (9)
 * 3、子类的非静态代码块 (3)
 * 4、子类的无参构造（最后）(2)
 *
 *
 * 非静态方法前面其实有一个默认的对象this
 * this在构造器或 <init> 他表示的是正在创建的对象，因为咱们这里是正在创建Son对象，所以
 * test()执行的就是子类重写的代码(面向对象多态)
 *
 * 这里i=test() 执行的就是子类重写的test()方法
 */
public class Code_03_Father {

    private int i = test();
    private static int j = method();

    static {
        System.out.print("(1)");
    }

    public Code_03_Father() {
        System.out.print("(2)");
    }

    {
        System.out.print("(3)");
    }

    public int test() {
        System.out.print("(4)");
        return 1;
    }

    public static int method() {
        System.out.print("(5)");
        return 1;
    }

}

