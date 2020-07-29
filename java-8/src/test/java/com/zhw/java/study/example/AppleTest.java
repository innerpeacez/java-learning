package com.zhw.java.study.example;

import com.zhw.java.study.pojo.apple.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleTest {

    List<Apple> apples;

    private AppleFilter appleFilter = new AppleFilter();
    private PrettyApplePrint prettyApplePrint = new PrettyApplePrint();

    public AppleTest() {
        List<Apple> appleList = new ArrayList<>();
        Apple green = new Apple("green", 10);
        Apple red = new Apple("red", 20);
        Apple yellow = new Apple("yellow", 30);
        Apple green2 = new Apple("green", 15);
        Apple red2 = new Apple("red", 25);
        Apple yellow2 = new Apple("yellow", 35);

        appleList.add(green);
        appleList.add(green2);
        appleList.add(red);
        appleList.add(red2);
        appleList.add(yellow);
        appleList.add(yellow2);

        this.apples = appleList;
    }

    @Test
    public void test1() {
//        List<Apple> greenApples = appleFilter.filterColor(apples, "green");
//        System.out.println(greenApples);
    }

    @Test
    public void test2() {
        GreenApplePredicate greenApplePredicate = new GreenApplePredicate();
        List<Apple> apples = appleFilter.filterColor(this.apples, greenApplePredicate);
        System.out.println(apples);
    }

    @Test
    public void testUp15Predicate() {
        Up15ApplePredicate up15ApplePredicate = new Up15ApplePredicate();
        List<Apple> apples = appleFilter.filterColor(this.apples, up15ApplePredicate);
        System.out.println(apples);
    }

    @Test
    public void testPrettyApplePrint() {
        PrettyAppleFormatter prettyAppleFormatter = new PrettyAppleFormatter();
        prettyApplePrint.printer(apples, prettyAppleFormatter);
    }

    @Test
    public void testSimpleApplePrint() {
        SimpleAppleFormatter simpleAppleFormatter = new SimpleAppleFormatter();
        prettyApplePrint.printer(apples, simpleAppleFormatter);
    }

    @Test
    public void testAnonymous() {
        List<Apple> apples = appleFilter.filterColor(this.apples, new ApplePredicate() {
            @Override
            public boolean filter(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        System.out.println(apples);
    }

    @Test
    public void testLambda() {
        List<Apple> apples = appleFilter.filterColor(this.apples, apple -> "yellow".equals(apple.getColor()));
        System.out.println(apples);
    }

    @Test
    public void testAbstract() {
        List<Integer> nums = Arrays.asList(10, 20, 2, 3, 4, 54, 6, 234);
        List<Integer> lessTen = new Filter<Integer>().filter(nums, i -> i < 10);
        System.out.println(lessTen);

    }
}
