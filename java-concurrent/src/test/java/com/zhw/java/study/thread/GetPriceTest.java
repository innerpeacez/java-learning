package com.zhw.java.study.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class GetPriceTest {

    class S {
        private int price;
        private String sName;

        public S(int price, String sName) {
            this.price = price;
            this.sName = sName;
        }

        public S() {
        }

        @Override
        public String toString() {
            return "GetPriceTest{" +
                    "price=" + price +
                    ", sName='" + sName + '\'' +
                    '}';
        }
    }

    @Test
    public void test() {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        S s1 = new S(1, "S1");
        S s2 = new S(2, "S2");
        S s3 = new S(3, "S3");

        ArrayList<FutureTask> tasks = new ArrayList<>();
        tasks.add(new FutureTask(() -> s1.toString()));
        tasks.add(new FutureTask(() -> s2.toString()));
        tasks.add(new FutureTask(() -> s3.toString()));

        tasks.parallelStream().forEach(ft -> {
            scheduledThreadPoolExecutor.execute(ft);

            try {
                final String price = (String) ft.get();
                System.out.println(price);
            } catch (Exception ignored) {
            }
        });
    }
}
