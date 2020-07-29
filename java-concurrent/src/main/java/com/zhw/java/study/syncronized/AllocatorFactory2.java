package com.zhw.java.study.syncronized;


public class AllocatorFactory2 {

    private static volatile Allocator2 allocator;

    public static Allocator2 getAllocatorInstance() {
        if (allocator == null) {
            synchronized (AllocatorFactory2.class) {
                if (allocator == null) {
                    allocator = new Allocator2();
                }
            }
        }
        return allocator;
    }
}
