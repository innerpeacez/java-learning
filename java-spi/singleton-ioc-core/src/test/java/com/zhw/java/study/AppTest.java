package com.zhw.java.study;

import static org.junit.Assert.assertTrue;

import com.zhw.java.study.bean.ZhwBeanFactory;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    @Test
    public void load() {
        ServiceLoader<ZhwBeanFactory> iocs = ServiceLoader.load(ZhwBeanFactory.class);
        for (ZhwBeanFactory ioc : iocs) {
            System.out.println(ioc.getClass().getName());
        }
    }
}
