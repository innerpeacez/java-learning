package com.zhw.java.study.syncronized;


/**
 * 破坏死锁条件占用且等待，同时获取所需的资源，要么同时获取到，要么都获取不到
 */
public class Account4 {
    // actr 应该为单例
    private Allocator2 actr = AllocatorFactory2.getAllocatorInstance();
    private long balance;

    public Account4(int balance) {
        this.balance = balance;
    }

    public Account4() {
    }

    // 转账
    public void transfer(Account4 target, int amt) {
        if (target == null) {
            throw new RuntimeException("target account can not empty!");
        }
        // 同时申请所需资源
        actr.apply(this, target);
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

    @Override
    public String toString() {
        return "Account4{" +
                "balance=" + balance +
                '}';
    }
}
