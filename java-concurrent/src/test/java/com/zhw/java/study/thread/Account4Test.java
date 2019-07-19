package com.zhw.java.study.thread;

import com.zhw.java.study.syncronized.Account4;
import org.junit.Test;

public class Account4Test {

    @Test
    public void accountTest() {
        Account4 a = new Account4(1000);
        Account4 b = new Account4(1000);
        Account4 c = new Account4(1000);

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
