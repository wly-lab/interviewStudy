package com.wly.第一季.递归和迭代;

import org.junit.jupiter.api.Test;

/**
 * 有n步台阶，一次只能上1步或者2步，共有多少种走法
 * f(n)=f(n-1)+f(n-2)
 */
public class Test1 {
    //递归 效率略低
    public int f(int n){
        if(n<1){
            throw new IllegalArgumentException("n不能小于1");
        }
        if(n==1||n==2){
            return n;
        }
        return f(n-2)+f(n-1);
    }
    //效率高 可读性低
    public int loop(int n){
        if(n<1){
            throw new IllegalArgumentException("n不能小于1");
        }
        if(n==1||n==2){
            return n;
        }
        int one=2;//初始化为走到第二级台阶的走法
        int two=1;//初始化为走到第一级台阶的走法
        int sum=0;

        for(int i=3;i<=n;i++){
            //最后跨两步+最后跨一步的走法
            sum=two+one;
            two=one;
            one=sum;
        }
        return sum;
    }

    @Test
    public  void test() {
        System.out.println(f(5));
    }
}
