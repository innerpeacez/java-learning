package com.zhw.java.study.syncronized;

public class SafeCalc {

    static long value = 0L;

    // 锁对象为 this
    synchronized long get() {
        return value;
    }

    // 锁对象为 SafeCalc.class
    synchronized static void addOne() {
        value += 1;
    }

    // 两个锁对象锁同一个资源，会出现线程安全问题
}
