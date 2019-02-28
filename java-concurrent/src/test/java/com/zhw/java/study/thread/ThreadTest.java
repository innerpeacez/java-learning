package com.zhw.java.study.thread;

import org.junit.Test;

public class ThreadTest {

    @Test
    public void testThread() {
        MyThread myThread = new MyThread();
        System.out.println("主线程开始");
        myThread.start();
        System.out.println("主线程结束");
    }

    @Test
    public void testRunnable() {
        Thread runnable = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my first thread run");
        });
        System.out.println("主线程开始");
        runnable.start();
        System.out.println("主线程结束");
    }
}
