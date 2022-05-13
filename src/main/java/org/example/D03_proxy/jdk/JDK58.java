package org.example.D03_proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDK58 implements JDKService {
    private Person target;

    @Override
    public Object getInstance(Person target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int count =0;
        System.out.println("我是58，我要给你找工作，现在已经拿到需求");
        System.out.println("开始物色");
        Object invoke = method.invoke(this.target, args);
        System.out.println("如果合适的话，准备面试！");
//        System.out.println("invoke:" + invoke+",count:"+(++count));
        return invoke;
    }
}
