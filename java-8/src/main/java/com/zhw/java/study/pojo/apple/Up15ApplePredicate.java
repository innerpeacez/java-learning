package com.zhw.java.study.pojo.apple;

public class Up15ApplePredicate implements ApplePredicate {

    @Override
    public boolean filter(Apple apple) {
        return apple.getWeight() > 15;
    }
}
