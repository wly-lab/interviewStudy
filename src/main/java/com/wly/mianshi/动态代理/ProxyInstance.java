package com.wly.mianshi.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyInstance {
    public static void main(String[] args) {
        /*final List<String> list = new ArrayList<String>();

        List<String> proxyInstance =
                (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                        list.getClass().getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                return method.invoke(list, args);
                            }
                        });
        proxyInstance.add("你好");
        System.out.println(list);*/

        List<String> list=new ArrayList<>();
        List<String> proxyInstance = (List<String>)Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(list, args);
            }
        });
        proxyInstance.add("hello");
        System.out.println(list);
    }
}
