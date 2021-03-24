package com.wly.atguigu.jucandjvm;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**ConcurrentHashMap/CopyOnWriteArraySet/CopyOnWriteArrayList
 * ArrayList 底层是Object数组
 * 初始化长度是10 第一次扩容扩容到15 扩容使用的Arrays.copyof() 第二次扩容扩容（15/2取整=7）到22
 * （扩展 hashmap初始长度16 扩容为1倍 32 64）
 * 线程不安全
 *
 * 1.故障现象
 * java.util.ConcurrentModificationException
 * 2.导致原因
 *
 * 3.解决方法
 *  3.1 使用Vector （since1.2）
 *  3.2 Collections.synchronizedList(new ArrayList<String>());
 *  3.3 ***CopyOnWriteArrayList(写时复制技术-读写分离思想的体现)：
 *  读的时候读取共享资源 写的时候，复制一份资源修改，修改后原资源引用指向新资源，写的操作是带锁的
 *
 *  HashSet底层是hashmap hashmap的value是一个常量
 *
 *
 *
 */
public class NotSafeDemo03 {
    public static void main(String[] args) {
        mapNotSafe();
    }



    public static void mapNotSafe() {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
    public static void setNotSafe(){
        Set<String> set=new CopyOnWriteArraySet<>();
        for (int i = 1; i <=30 ; i++) {
            new Thread(() ->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
    public static void listNotSafe(){
        // List<String> list=new ArrayList<>();
        // List<String> list=new Vector<>();
        // List<String> list= Collections.synchronizedList(new ArrayList<String>());
        List<String> list=new CopyOnWriteArrayList<>();
        for (int i = 1; i <=30 ; i++) {
            new Thread(() ->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
