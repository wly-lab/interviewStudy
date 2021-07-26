package com.wly.第一季.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Singleton4 instance1 = Singleton4.getInstance();
        // Singleton4 instance2 = Singleton4.getInstance();
        // System.out.println(instance1==instance2);
        // System.out.println(instance1);
        // System.out.println(instance2);

        Callable<Singleton4> ca=new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };
        ExecutorService ex= Executors.newFixedThreadPool(2);
        Future<Singleton4> submit = ex.submit(ca);
        Future<Singleton4> submit1 = ex.submit(ca);
        Singleton4 singleton4 = submit.get();
        Singleton4 singleton41 = submit1.get();
        System.out.println(singleton4==singleton41);
        ex.shutdown();
    }
}
