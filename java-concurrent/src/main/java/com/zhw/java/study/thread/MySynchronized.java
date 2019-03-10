package com.zhw.java.study.thread;

public class MySynchronized {

    int value = 0;

    static int value2 = 0;

    public void add(int value) {
        synchronized (this) {
            this.value += value;
        }
    }

    public static void add2(int value) {

        synchronized (MySynchronized.class) {
            value2 = value;
        }
    }
}
