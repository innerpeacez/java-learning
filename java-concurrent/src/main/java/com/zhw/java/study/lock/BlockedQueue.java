package com.zhw.java.study.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull = lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty = lock.newCondition();

    private static final int MAX_SIZE = 10;
    private Queue<T> queue = new ConcurrentLinkedQueue<>();

    // 入队
    void enq(T x) {
        lock.lock();
        try {
            while (queue.size() >= MAX_SIZE)
                notFull.await();// 等待到 queue 不满
            queue.add(x);
            // 入队后,通知可出队
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 出队
    void deq() {
        lock.lock();
        try {
            while (queue.isEmpty())
                // 等待到 queue 不空
                notEmpty.await();
            // 省略出队操作...
            //出队后，通知可入队
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
