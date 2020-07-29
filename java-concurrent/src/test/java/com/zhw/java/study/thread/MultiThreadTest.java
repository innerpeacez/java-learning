package com.zhw.java.study.thread;

import org.junit.Test;


public class MultiThreadTest {

    @Test
    public void testCounter() throws InterruptedException {
        Counter counter = new Counter();
        long sum = 0L;
        for (int i = 0; i < 1000; i++) {
            final long num = i;
            new Thread(() -> {
                counter.add(num);
                System.out.println(Thread.currentThread().getName()+":"+counter.count);
            }, "thread" + i).start();

        }

        Thread.sleep(10000);

        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("count:" + counter.count);
        System.out.println("sum=" + sum);
    }


    class Counter {
        protected long count = 0L;

        public void add(long value) {
            this.count = this.count + value;
        }
    }
}
