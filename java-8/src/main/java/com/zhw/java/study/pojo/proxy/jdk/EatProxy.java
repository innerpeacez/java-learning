package com.zhw.java.study.pojo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EatProxy implements InvocationHandler {

    Object object;

    EatMethod eatMethod = new EatMethod();

    public EatProxy(Object object) {
        this.object = (XiaoDD) object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        eatMethod.addSomething();
        method.invoke(object,args);
        return null;
    }
}
