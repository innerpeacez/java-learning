package com.zhw.java.study.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("my first runnable run");
    }
}
