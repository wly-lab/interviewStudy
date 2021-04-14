package com.wly.atguigu.第二季.com.wly;

import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number=0;
    public void addTo60(){
        this.number=60;
    }
    //请注意，此时number是添加了volatile关键字修饰的 volatile不保证原子性
    public  void addPlusPlus(){
        number++;
    }
    AtomicInteger atomicInteger=new AtomicInteger();

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 验证volatile的可见性 不保证原子性
 * 1.什么是原子性：原子性指的什么意思？
 * 不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。
 * 需要整体完整，要么同时成功，要么同时失败
 * 2.如何解决原子性
 *  *加sync
 *  *使用juc下AtomicInteger
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData=new MyData();
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 1; j <=1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程都全部计算完成后，再用main线程去的最终结果只看是多少
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"finally number:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"atomicInteger finally number:"+myData.atomicInteger);
    }
}
