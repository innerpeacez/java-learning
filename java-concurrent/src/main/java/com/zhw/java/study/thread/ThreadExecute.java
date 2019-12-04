package com.zhw.java.study.thread;

public class ThreadExecute {


    public static void main(String[] args) {



        Thread t1 = new Thread(ThreadExecute::threadAction, "t1");
        Thread t2 = new Thread(ThreadExecute::threadAction, "t2");
        Thread t3 = new Thread(ThreadExecute::threadAction, "t3");

        threadStartAndJoin(t1);
        threadStartAndJoin(t2);
        threadStartAndJoin(t3);

    }

    public static void threadStartAndJoin(Thread thread) {
        if (Thread.State.NEW.equals(thread.getState())) {
            thread.start();
        }

        while (thread.isAlive()) {
//            System.out.printf("1 name: %s , state: %s\n", thread.getName(), thread.getState());
            synchronized (thread) {
//                System.out.printf("2 name: %s , state: %s\n", thread.getName(), thread.getState());
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.printf("3 name: %s , state: %s\n", thread.getName(), thread.getState());
            }
        }

    }

    public static void threadAction() {
        System.out.println(Thread.currentThread().getName());
    }
}
