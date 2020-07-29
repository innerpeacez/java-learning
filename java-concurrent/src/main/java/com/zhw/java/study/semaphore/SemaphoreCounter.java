package com.zhw.java.study.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {

    private int count;
    private final Semaphore sem = new Semaphore(1);

    public void addOne() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            count++;
        } finally {
            sem.release();
        }
    }
}
