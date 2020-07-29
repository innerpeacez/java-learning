package com.zhw.java.study.thread;

import org.junit.Test;

public class TestThreadLocal {

    @Test
    public void Test() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("1 thread local");
        threadLocal.set("2 thread local");
        threadLocal.set("3 thread local");
        threadLocal.set("4 thread local");
        String str = String.valueOf(threadLocal.get());

        System.out.println(str);
    }

    @Test
    public void test2() {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("string thread local");

        String str = stringThreadLocal.get();
        System.out.println(str);
    }

    @Test
    public void test3() {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "this is the initial value");

        String str = threadLocal.get();

        System.out.println(str);

    }

    @Test
    public void test4() throws InterruptedException {
        ThreadLocal<Boolean> threadLocal = ThreadLocal.withInitial(() -> false);

        Thread t1 = new Thread(() -> {
            System.out.println(".....");
            while (threadLocal.get()) {
                System.out.println("可以运行了");
            }
        });
        t1.start();


        Thread t2 = new Thread(() -> {
            System.out.println("发送信号");
            threadLocal.set(true);
        });
        t2.start();

        t1.join();
        t2.join();
    }

    @Test
    public void test5() throws InterruptedException {

        ThreadLocal<String> inheritableThreadLocal = new ThreadLocal<>();
        inheritableThreadLocal.set("parent");
        Thread thread = new Thread(() -> {
            String str = inheritableThreadLocal.get();
            System.out.println(str);
            new Thread(() -> {
                System.out.println(inheritableThreadLocal.get());
            }).start();

        });
        thread.start();
        thread.join();
    }
}
