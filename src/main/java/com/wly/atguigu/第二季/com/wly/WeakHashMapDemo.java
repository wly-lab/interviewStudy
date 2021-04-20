package com.wly.atguigu.第二季.com.wly;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 *key 不被使用 gc就会被回收
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("===============");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,String> map=new WeakHashMap<>();
        Integer key=new Integer(2);
        String value="WeakHashMap";
        map.put(key,value);
        System.out.println(map);

        key=null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    public static  void myHashMap(){
        HashMap<Integer,String> map=new HashMap<>();
        Integer key=new Integer(1);
        String value="HashMap";
        map.put(key,value);
        System.out.println(map);

        key=null;
        System.out.println(map);

        System.gc();
        System.out.println(map);





    }
}
