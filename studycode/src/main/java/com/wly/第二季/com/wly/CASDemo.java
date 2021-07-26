package com.wly.第二季.com.wly;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是什么？   ==>compareAndSet
 * 比较并交换
 *
 * 底层是usafe类+CAS思想（自旋）
 * CAS缺点：
 * 1.循环时间长 cpu开销大
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 6)+"值："+atomicInteger.get());
    }
}
