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
        System.out.println("主线程开始:" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println("my first thread run "+Thread.currentThread().getName())," thread" + i).start();
        }
        System.out.println("主线程结束");
    }
}
