package com.zhw.java.study.thread;

import com.zhw.java.study.syncronized.Account1;
import org.junit.Test;

public class Account1Test {

    @Test
    public void accountTest() {
        Account1 a = new Account1(1000);
        Account1 b = new Account1(1000);
        Account1 c = new Account1(1000);

        int x = 10;
        while (x > 0) {
            new Thread(() -> a.transfer(b, 10)).start();
//            new Thread(() -> b.transfer(a, 10)).start();
            new Thread(() -> b.transfer(c, 10)).start();
            x--;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("\na: %s \nb: %s \nc: %s", a, b, c);
    }

}
