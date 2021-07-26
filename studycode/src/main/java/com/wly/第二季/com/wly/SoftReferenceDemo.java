package com.wly.第二季.com.wly;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 内存够用的时候就保留 不够用就会被回收
 */
public class SoftReferenceDemo {

    /**
     * 内存够用的时候就保留 不够用就会被回收
     */
    public static void  softRef_Memory_Enough(){
        Object o1=new Object();
        SoftReference<Object> softReference=new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1=null;
        System.gc();
        System.out.println(softReference.get());
    }

    public static void  softRef_Memory_NotEnough(){
        Object o1=new Object();
        SoftReference<Object> softReference=new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1=null;
        try{
            byte[] bytes=new byte[30*1024*1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(softReference.get());

        }
    }
    public static void main(String[] args) {
        softRef_Memory_Enough();
    }
}
