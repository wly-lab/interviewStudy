package com.wly.jucandjvm;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 和countDownLatch 类似，这个是加法的
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("****召唤神龙");
        });

        for (int i = 1; i <=7 ; i++) {
            final int j=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到第"+j+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
