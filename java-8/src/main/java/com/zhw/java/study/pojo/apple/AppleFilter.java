package com.zhw.java.study.pojo.apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter {

    public List<Apple> filterColor(List<Apple> apples, ApplePredicate predicate) {
        ArrayList<Apple> colorApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.filter(apple)) {
                colorApples.add(apple);
            }
        }
        return colorApples;
    }
}
