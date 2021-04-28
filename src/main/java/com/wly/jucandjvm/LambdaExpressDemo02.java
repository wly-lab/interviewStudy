package com.wly.jucandjvm;

@FunctionalInterface
interface  Foo{
    //public void sayHello();
    public int add(int x,int y);

    default  int mul(int x,int y){
        return x*y;
    }

    public static int div(int x,int y){
        return x/y;
    }
}
/**
 * 1.函数式编程  拷贝中括号 写死右箭头 落地大括号
 * 2.@FunctionalInterface 函数式接口 未明确声明方法体的方法只能有1个
 * 3.default 可以有多个
 * 4. static 可以有多个
 */
public class LambdaExpressDemo02 {
    public static void main(String[] args) {
        // Foo foo=new Foo() {
        //     @Override
        //     public void sayHello() {
        //         System.out.println("***nihao");
        //     }
        // };
        // foo.sayHello();

        //函数式编程
        // Foo foo=() -> {System.out.println("***nihao");};
        // foo.sayHello();

        Foo foo=(int x,int y) ->{
            System.out.println("come in add method");
            return x+y;
        };
        int add = foo.add(3, 4);
        System.out.println(add);

        System.out.println(foo.mul(3, 5));

        System.out.println(Foo.div(12, 4));
    }
}
