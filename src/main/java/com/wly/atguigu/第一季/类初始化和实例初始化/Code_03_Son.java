package com.wly.atguigu.第一季.类初始化和实例初始化;


/**
 * 子类的初始化 <clinit>
 * 1、j = method()
 * 2、子类的静态代码块
 *
 * 先初始化父类 (5)(1)
 * 后初始化子类 (10) (6)
 *
 * 子类实例化方法:
 * 1、super()（最前）
 * 2、i = test() (9)
 * 3、子类的非静态代码块 (8)
 * 4、子类的无参构造（最后） (7)
 */
public class Code_03_Son extends Code_03_Father{

    private int i = test();
    private static int j = method();

    static {
        System.out.print("(6)");
    }

    public Code_03_Son() {
        System.out.print("(7)");
    }

    {
        System.out.print("(8)");
    }

    public int test() {
        System.out.print("(9)");
        return 1;
    }
    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Code_03_Son s1 = new Code_03_Son(); // 5 1 10 6 9 3 2 9 8 7
        System.out.println();
        Code_03_Son s2 = new Code_03_Son(); // 9 3 2 9 8 7
    }

}