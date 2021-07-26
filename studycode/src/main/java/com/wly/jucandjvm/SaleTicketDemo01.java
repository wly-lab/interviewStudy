package com.wly.jucandjvm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int number =30;
    Lock lock=new ReentrantLock();
    public void sale(){
        try{
            lock.lock();
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"售出了第："+number--+"票，还剩："+number+"张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


/**
 * 题目：三个售票员 买出 30张票
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(() ->{for(int i=0;i<=40;i++) ticket.sale();},"A").start();
        new Thread(() ->{for(int i=0;i<=40;i++) ticket.sale();},"B").start();
        new Thread(() ->{for(int i=0;i<=40;i++) ticket.sale();},"C").start();
    }

}
