package com.zhw.java.study.lock;

import java.util.concurrent.locks.StampedLock;

public class FristStampedLock {


    private final StampedLock stampedLock = new StampedLock();

    private int v;

    public void addOne() {
        final long stamp = stampedLock.writeLock();
        try {
            v++;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public int getV() {
        final long stamp = stampedLock.readLock();
        try {
            return v;
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }
}
