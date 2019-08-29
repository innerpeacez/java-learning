package com.zhw.java.study;

import org.junit.Test;

import java.util.Timer;

public class MyTimerTaskTest {
    @Test
    public void test() {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 0, 10);

        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
