package com.wly.jucandjvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService threadpool=new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory()
                ,new ThreadPoolExecutor.CallerRunsPolicy());
        initThreadPool();
        try{
            for (int i = 1; i <=10 ; i++) {
                threadpool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadpool.shutdown();
        }
    }

    public static void initThreadPool() {
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();
        ExecutorService threadPool= Executors.newCachedThreadPool();
        try{
            for (int i = 1; i <=8 ; i++) {
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
