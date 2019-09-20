package com.zhw.java.study.thread;

import com.zhw.java.study.pool.MyThreadPool;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolTest {
    @Test
    public void test() throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        MyThreadPool pool = new MyThreadPool(10, workQueue);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        int threadCount = 0;
        while (threadCount < 1000) {
            pool.execute(() -> {
                System.out.println("hello");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread());
            });
            threadCount++;
        }
        countDownLatch.await();
    }
}
