package com.zhw.java.study.pojo.apple;

import java.util.List;

public class PrettyApplePrint {

    public void printer(List<Apple> apples, AppleFormatter appleFormatter) {

        for (Apple apple : apples) {
            String accept = appleFormatter.accept(apple);
            System.out.println(accept);
        }
    }
}
