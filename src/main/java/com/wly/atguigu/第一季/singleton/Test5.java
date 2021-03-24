package com.wly.atguigu.第一季.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Singleton5 instance1 = Singleton5.getInstance();
        // Singleton5 instance2 = Singleton5.getInstance();
        // System.out.println(instance1==instance2);
        // System.out.println(instance1);
        // System.out.println(instance2);

        Callable<Singleton5> ca=new Callable<Singleton5>() {
            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };
        ExecutorService ex= Executors.newFixedThreadPool(2);
        Future<Singleton5> submit = ex.submit(ca);
        Future<Singleton5> submit1 = ex.submit(ca);
        Singleton5 Singleton5 = submit.get();
        Singleton5 Singleton51 = submit1.get();
        System.out.println(Singleton5==Singleton51);
        ex.shutdown();
    }
}
