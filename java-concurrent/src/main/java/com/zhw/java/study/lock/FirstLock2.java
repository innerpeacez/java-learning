package com.zhw.java.study.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FirstLock2 {

    private final Lock rt1 = new ReentrantLock();

    private int value;

    public void addOne() {
        rt1.lock();
        try {
            value = 1 + getValue();
        } finally {
            rt1.unlock();
        }
    }

    public int getValue() {
        rt1.lock();
        try {
            return value;
        } finally {
            rt1.unlock();
        }
    }
}
