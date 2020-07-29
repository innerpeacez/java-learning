package com.zhw.java.study.syncronized;


public class AllocatorFactory {

    private static volatile Allocator allocator;

    public static Allocator getAllocatorInstance() {
        if (allocator == null) {
            synchronized (AllocatorFactory.class) {
                if (allocator == null) {
                    allocator = new Allocator();
                }
            }
        }
        return allocator;
    }
}
