package org.example.D03_proxy.custom;


import org.example.D03_proxy.jdk.JDKService;
import org.example.D03_proxy.jdk.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 86158
 */
public class GPJDKMeiPo implements GPInvocationHandler {
    private Person target;


    public Object getInstance(Person target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int count =0;
        System.out.println("我是媒婆，我要给你找对象，现在已经拿到需求");
        System.out.println("开始物色");
        Object invoke = method.invoke(this.target, args);
        System.out.println("如果合适的话，准备结婚！");
//        System.out.println("invoke:" + invoke+",count:"+(++count));
        return invoke;
    }
}
