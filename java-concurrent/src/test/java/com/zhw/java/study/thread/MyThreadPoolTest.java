package com.zhw.java.study.thread;

import com.zhw.java.study.pool.MyThreadPool;
import org.junit.Test;

import java.util.concurrent.*;

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


    @Test
    public void testExecutors() throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        CountDownLatch countDownLatch = new CountDownLatch(10000);
        int threadCount = 0;
        while (threadCount < 10000) {
            int finalThreadCount = threadCount;
            threadPoolExecutor.execute(() -> {
                countDownLatch.countDown();
                System.out.printf("order: %s, threadName: %s \n", finalThreadCount, Thread.currentThread().getName());
            });
            threadCount++;
        }
        countDownLatch.await();
    }
}
