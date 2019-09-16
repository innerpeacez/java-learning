package com.zhw.java.study.thread;

import com.zhw.java.study.nolock.Counter;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NoLockCounterTest {

    @Test
    public void test() {
        final Counter counter = new Counter();
        // 使用线程池
        Executor executor = Executors.newFixedThreadPool(4);
        int idx = 0;
        CountDownLatch latch = new CountDownLatch(10000);

        while (idx++ < 10000) {
            executor.execute(() -> {
                counter.addOne();
                latch.countDown();
            });
        }

        // 等待所有线程执行完
        try {
            latch.await();
        } catch (InterruptedException ignored) {
        }

        System.out.println(counter.get());
    }
}
