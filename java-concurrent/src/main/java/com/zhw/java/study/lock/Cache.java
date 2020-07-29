package com.zhw.java.study.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {

    private final Map<K, V> map = new HashMap<>();
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    V get(K key) {
        V value = null;
        r.lock();
        try {
            value = map.get(key);
        } finally {
            r.unlock();
        }

        if (value != null) {
            return value;
        }

        w.lock();
        try {
            value = map.get(key);
            if (value == null) {
                value = (V) "查询数据库操作所得";
                map.put(key, value);
            }
        } finally {
            w.unlock();
        }
        return value;
    }

    V put(K key, V value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }
}
