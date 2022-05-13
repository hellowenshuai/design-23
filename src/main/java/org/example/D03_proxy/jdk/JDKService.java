package org.example.D03_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public interface JDKService extends InvocationHandler {

    Object getInstance(Person target);

    @Override
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
