package com.zhw.java.study.pojo.apple;

public class MeaningOfThis {

    public final int value = 4;

    public void doit() {
        int value = 5;
        new Runnable() {
            private final int value = 6;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        }.run();
    }

    public static void main(String[] args) {
        MeaningOfThis meaningOfThis = new MeaningOfThis();
        meaningOfThis.doit();
    }
}
