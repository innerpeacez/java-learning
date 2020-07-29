package com.zhw.java.study;

import com.zhw.java.study.bean.ZhwBeanFactory;

import java.util.ServiceLoader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ServiceLoader<ZhwBeanFactory> iocFactory = ServiceLoader.load(ZhwBeanFactory.class);
        for (ZhwBeanFactory zhwBeanFactory : iocFactory) {
            zhwBeanFactory.register(new Object());
        }
    }
}
