package com.zhw.java.study.pojo.apple;

public class GreenApplePredicate implements ApplePredicate {

    @Override
    public boolean filter(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
