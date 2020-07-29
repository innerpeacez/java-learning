package com.zhw.java.study.nolock;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private final AtomicLong count = new AtomicLong(0);

    public void addOne() {
        count.getAndIncrement();
    }

    public long get() {
        return count.get();
    }
}
