package com.wly.atguigu.jucandjvm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in call()");
        return 1024;
    }
}

/**
 *
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask(new MyThread());
        new Thread(futureTask).start();
        Integer result=futureTask.get();
        System.out.println(result) ;
    }
}
