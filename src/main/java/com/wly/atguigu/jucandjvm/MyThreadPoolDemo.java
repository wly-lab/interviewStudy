package com.wly.atguigu.jucandjvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();
        ExecutorService threadPool= Executors.newCachedThreadPool();
        try{
            for (int i = 1; i <=10 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
