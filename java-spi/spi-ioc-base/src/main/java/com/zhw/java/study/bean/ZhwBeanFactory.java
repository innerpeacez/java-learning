package com.zhw.java.study.bean;

public interface ZhwBeanFactory {

    void register(Object object);

    Object getBean(String name) throws Exception;

    <T> T getBean(Class<T> clazz) throws Exception;

    void releaseBean();
}
