package com.wly.atguigu.jucandjvm;

import java.util.concurrent.TimeUnit;

class  Phone{
    public static synchronized void  sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("******sendEmail");
    }

    public  synchronized void  sendSMS() throws Exception{
        System.out.println("******sendSMS");
    }

    public  void  sayHello() throws Exception{
        System.out.println("******sayHello");
    }
}

/**
 * 1.标准访问，请问先打印邮件还是短信
 *    --一个对象里面如果有多个synchronized方法，某一时刻内，只要有一个线程去调用其中的一个synchronized方法了，
 *      其他线程都只能等待，换句话说，某一时刻内，只能有唯一的一个线程去访问这些synchronized方法
 *      锁的是当前对象this，被锁定后，其他线程都不能进入到当前对象的其他synchronized方法
 *    --锁的是对象，不是方法
 * 2.暂停4秒钟在邮件方法,请问先打印邮件还是短信 --》邮件
 *      -证明了以上的解释
 * 3.新增普通sayHello方法，先打印邮件还是Hello --》hello
 *      --加一个普通方法后发现和同步锁无关
 * 4.两部手机，先打印邮件还是短信 --》短信
 *      --换成两个对象后，不是同一把锁了
 * 5.两个静态同步方法 同一部手机--》邮件
 *      --static synchronized 是全局锁，锁的是类，之前的是对象锁
 *      synchronized实现同步的基础：JAVA中的每一个对象都可以作为锁
 *      具体表现为以下3种形式
 *      对于普通同步方法，锁的是当前实例对象
 *      对于同步方法块，锁的是synchronized括号里配置的对象
 *      对于静态同步方法，锁的是当前类的Class对象
 * 6.两个静态同步方法 两部手机  --》邮件
 *     --同上
 * 7.一个静态同步方法 一个普通同步方法 同一部手机 --》短信
 *      --锁的对象不是同一个 不冲突
 * 8.一个静态同步方法 一个普通同步方法 两部手机 --》短信
 *      --锁的不是一个对象 不冲突
 */

public class Lock8Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone=new Phone();
        Phone phone2=new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        Thread.sleep(100);
        new Thread(()->{
            try {
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
