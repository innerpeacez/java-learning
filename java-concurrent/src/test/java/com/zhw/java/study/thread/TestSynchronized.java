package com.zhw.java.study.thread;

import org.junit.Test;

import java.util.ArrayList;

public class TestSynchronized {

    @Test
    public void test1() throws InterruptedException {
        MySynchronized mySynchronized = new MySynchronized();

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            nums.add(1);
        }
        nums.parallelStream().forEach(num -> mySynchronized.add(num));

        System.out.println(mySynchronized.value);
    }
}
