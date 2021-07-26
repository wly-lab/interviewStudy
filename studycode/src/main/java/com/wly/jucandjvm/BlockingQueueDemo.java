package com.wly.jucandjvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * 两个数据结构：栈和队列
 * 1.1 栈 后进先出
 * 1.2队列 先进先出
 * 1.3总结
 *
 * 2.阻塞队列
 * 2.1 阻塞 必须要阻塞、不得不阻塞
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        List list=new ArrayList();
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // System.out.println(blockingQueue.add("x"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // System.out.println(blockingQueue.remove());*/

        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.element());//检查队列的第一个
        */

       /* System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));//超过界限时不回抛异常，而是返回false

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//没有时不报错，返回null
        */

       /* blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        //blockingQueue.put("a");//超过界限将会一直阻塞等待


        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();//为空时一直阻塞*/

        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
        //超过时等待3秒 不成功返回false
        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
    }
}
