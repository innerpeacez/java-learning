package com.zhw.java.study.thread;

import com.zhw.java.study.syncronized.Account;
import org.junit.Test;

public class AccountTest {

    @Test
    public void accountTest() {
        Account a = new Account(1000);
        Account b = new Account(1000);
        Account c = new Account(1000);

        int x = 10;
        while (x > 0) {
            new Thread(() -> a.transfer(b, 10)).start();
            new Thread(() -> b.transfer(a, 10)).start();
//            new Thread(() -> b.transfer(c, 10)).start();
            x--;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("\na: %s \nb: %s \nc: %s", a, b, c);
    }
}
