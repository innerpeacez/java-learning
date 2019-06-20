package com.zhw.java.study.pojo.apple;

public class PrettyAppleFormatter implements AppleFormatter {

    public String accept(Apple apple) {
        String character = apple.getWeight() > 15 ? "heavy" : "light";
        return "A " + character + " " + apple.getColor() + " apple";
    }
}
