package com.zhw.java.study.syncronized;

import com.zhw.java.study.utils.DateTimeUtils;

import java.time.LocalDateTime;

/**
 * 破坏死锁条件占用且等待，同时获取所需的资源，要么同时获取到，要么都获取不到
 */
public class Account1 {
    // actr 应该为单例
    private Allocator actr = AllocatorFactory.getAllocatorInstance();
    private long balance;

    public Account1(int balance) {
        this.balance = balance;
    }

    public Account1() {
    }

    // 转账
    public void transfer(Account1 target, int amt) {
        if (target == null) {
            throw new RuntimeException("target account can not empty!");
        }
        // 一次性申请转出账户和转入账户，直到成功
        this.applyResource(target);

        try {
            // 锁定转出账户
            synchronized (this) {
                // 锁定转入账户
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            // 释放
            actr.free(this, target);
        }
    }

    private void applyResource(Account1 target) {
        final LocalDateTime start = LocalDateTime.now();
        while (!actr.apply(this, target)) {
            final LocalDateTime end = LocalDateTime.now();
            if (DateTimeUtils.usedMilliOfDateTime(start, end) > 5 * 1000L) {
                throw new RuntimeException("applied resource timeout");
            }
        }
    }

    @Override
    public String toString() {
        return "Account1{" +
                "actr=" + actr +
                ", balance=" + balance +
                '}';
    }
}
