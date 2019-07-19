package com.zhw.java.study.thread;

import com.zhw.java.study.syncronized.Account3;
import org.junit.Test;

public class Account3Test {

    @Test
    public void accountTest() {
        Account3 a = new Account3(1000, 1);
        Account3 b = new Account3(1000, 2);
        Account3 c = new Account3(1000, 3);

        int x = 10;
        while (x > 0) {
            new Thread(() -> a.transfer(b, 10)).start();
            new Thread(() -> b.transfer(a, 10)).start();
//            new Thread(() -> b.transfer(c, 10)).start();
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
