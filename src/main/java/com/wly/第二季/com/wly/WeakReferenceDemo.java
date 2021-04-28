package com.wly.第二季.com.wly;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1=new Object();
        WeakReference<Object> weakReference=new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference);

        o1=null;
        System.gc();
        System.out.println("=================");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
