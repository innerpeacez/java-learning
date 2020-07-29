package com.zhw.java.study.semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ObjPool<T, R> {

    final List<T> pool;

    final Semaphore sem;

    public ObjPool(List<T> pool) {
        this.pool = pool;
        sem = null;
    }
}
