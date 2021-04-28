package com.wly.jucandjvm;

class MyNumber{
    volatile int number=10;
    public void addTo1205(){
        this.number=1205;
    }
}

/**
 * 可见性
 *不加volatile则main不停止，没人通知
 */
public class T2 {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        new Thread(()->{
            System.out.println("***come in" );
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNumber.addTo1205();
            System.out.println("***update to 1205");
        }).start();
        while (myNumber.number==10){
            //需要有人通知才能跳出
        }
        System.out.println("end");
    }
}
 