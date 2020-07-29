package com.zhw.java.study.syncronized;

/**
 * 破环循环等待条件，按顺序获取资源
 */
public class Account3 {
    private long balance;
    private long id;

    public Account3(long balance, long id) {
        this.balance = balance;
        this.id = id;
    }

    public Account3() {
    }

    // 转账
    public void transfer(Account3 target, int amt) {
        if (target == null) {
            throw new RuntimeException("target account can not empty!");
        }

        Account3 _1 = this;
        Account3 _2 = target;

        if (this.id > target.id) {
            _1 = target;
            _2 = this;
        }

        // 根据 id 的大小顺序上锁
        // 锁定 id 较小的账户
        synchronized (_1) {
            // 锁定 id 较大的账户
            synchronized (_2) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Account3{" +
                "balance=" + balance +
                ", id=" + id +
                '}';
    }
}
