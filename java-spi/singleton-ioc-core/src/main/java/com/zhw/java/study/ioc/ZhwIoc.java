package com.zhw.java.study.ioc;

import com.zhw.java.study.bean.ZhwBeanFactory;

public class ZhwIoc implements ZhwBeanFactory {
    @Override
    public void register(Object object) {
        System.out.println("register");
    }

    @Override
    public Object getBean(String name) throws Exception {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> clazz) throws Exception {
        return null;
    }

    @Override
    public void releaseBean() {

    }
}
