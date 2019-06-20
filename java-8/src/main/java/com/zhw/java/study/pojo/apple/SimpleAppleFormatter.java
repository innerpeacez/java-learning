package com.zhw.java.study.pojo.apple;

public class SimpleAppleFormatter implements AppleFormatter {

    public String accept(Apple apple) {
        return "apple`s weight is " + apple.getWeight() + " ,and color is " + apple.getColor();
    }
}
