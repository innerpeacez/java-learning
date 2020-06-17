package com.zhw.java.study.proxy;

import com.zhw.java.study.pojo.proxy.jdk.EatProxy;
import com.zhw.java.study.pojo.proxy.jdk.Person;
import com.zhw.java.study.pojo.proxy.jdk.XiaoDD;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class JdkProxyTest {

    @Test
    public void test() {

        XiaoDD xiaoDD = new XiaoDD();
        InvocationHandler eatProxy = new EatProxy(xiaoDD);
        Person o = (Person) Proxy.newProxyInstance(eatProxy.getClass().getClassLoader(), xiaoDD.getClass().getInterfaces(), eatProxy);
        o.doSomething();
    }
}
