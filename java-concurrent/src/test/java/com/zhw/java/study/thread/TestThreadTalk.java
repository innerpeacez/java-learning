package com.zhw.java.study.thread;

import org.junit.Test;

public class TestThreadTalk {

    @Test
    public void test() throws InterruptedException {
        MySignal mySignal = new MySignal();

        new Thread(() -> {

            while (!mySignal.hasDataToProcess) {
//                System.out.println("等待线程 A 完成她的工作，我才能工作");
            }
            System.out.println("线程 A 完成了，我工作了");
        }, "线程B").start();

        new Thread(() -> {
            System.out.println("我完成了，我的工作！，线程B可以开始工作了");

            mySignal.hasDataToProcess = true;

        }, "线程A").start();

        Thread.sleep(1000);
    }

    @Test
    public void test2() {
        String s = "";
        try {
            s.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        MyWaitNotify myWaitNotify = new MyWaitNotify();

        new Thread(()->{
            myWaitNotify.doWait();
            System.out.println("do every thing");

        }).start();

//        new Thread(()->{
//            myWaitNotify.doWait();
//            System.out.println("working");
//        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000 *3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify");
            myWaitNotify.doNotify();
        }).start();

        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
