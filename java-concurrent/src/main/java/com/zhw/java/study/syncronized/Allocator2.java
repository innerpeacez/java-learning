package com.zhw.java.study.syncronized;

import java.util.ArrayList;
import java.util.List;

/**
 *  等待通知机制改善循环等待
 */
public class Allocator2 {
    private List<Object> als = new ArrayList<>(1000);

    // 一次性申请所有资源
    synchronized void apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            try {
                // 一旦有线程获取了，申请资源中的任意一个，则让线程进入等待队列
                wait(); // wait 方法会释放已经获得的锁对象
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            als.add(from);
            als.add(to);
        }
    }

    // 归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        // 线程归还资源时，唤醒所有等待的线程
        notifyAll();
    }
}
