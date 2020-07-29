package com.zhw.java.study.thread;

import com.zhw.java.study.lock.FirstLock;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstLockTest {

    @Test
    public void test() {
        FirstLock firstLock = new FirstLock();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(firstLock::addOne));
        }

        threads.parallelStream().forEach(Thread::start);
        threads.parallelStream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("value = " + firstLock.getValue());
    }
}
