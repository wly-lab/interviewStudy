package com.wly.atguigu.第二季.com.wly;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized  void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t sendSMS");
        sendEmail();
    }

    public synchronized  void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t sendEmail");
    }
    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t get()");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t set()");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 可重入锁 也叫递归锁
 *
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 * 也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 */
public class ReenterLockDemo {
    public static void main(String[] args) throws Exception{
        Phone phone=new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        new Thread(phone,"t3").start();
    }
}
