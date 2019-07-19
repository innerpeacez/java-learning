package com.zhw.java.study.syncronized;

public class Account {

    private long balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public Account() {
    }

    // 转账
    public void transfer(Account target, int amt) {
        // 两把锁解决线程安全问题，但是会出现死锁，当a给b转账时，b也给a转账且a获得了自己的锁，b获取了自己的锁时，会发生死锁
        synchronized (this) {
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}