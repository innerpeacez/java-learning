package com.zhw.java.study.pojo.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EatInterceptor implements MethodInterceptor {

    private EatMethod eatMethod = new EatMethod();

    private Object object;

    public EatInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        eatMethod.addSomething();
        methodProxy.invoke(object, objects);
        return null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
