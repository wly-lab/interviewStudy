package com.wly.jucandjvm;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *在信号量上定义两种操作
 * acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1）
 *  要么一直等下去，直到有线程释放信号量，或超时
 * release（释放）实际上会将信号量的值+1，然后唤醒等待的线程
 *
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程的控制
 *
 * 数字==1时相当于synchronized 多线程抢一个资源，抢到的持有30秒就用此实现
 */
public class SemaphorDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢占到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 离开到了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                System.out.println("");
            },String.valueOf(i)).start();
        }
    }
}
