package com.zhw.java.study.proxy;

import com.zhw.java.study.pojo.proxy.cglib.EatInterceptor;
import com.zhw.java.study.pojo.proxy.cglib.XiaoMM;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class CglibTest {

    @Test
    public void test() {
        EatInterceptor eatInterceptor = new EatInterceptor(new XiaoMM());
        XiaoMM xiaoMM = (XiaoMM) Enhancer.create(XiaoMM.class, eatInterceptor);
        xiaoMM.doSomething();
    }
}
