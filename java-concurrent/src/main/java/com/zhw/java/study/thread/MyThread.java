package com.zhw.java.study.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("my first thread run");
    }


}
