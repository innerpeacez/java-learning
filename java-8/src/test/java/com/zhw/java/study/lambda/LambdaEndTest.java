package com.zhw.java.study.lambda;

import com.zhw.java.study.pojo.apple.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaEndTest {

    @Test
    public void endTest() {
        BiFunction<String,Long, Apple> biFunction = Apple::new;
        Apple green = biFunction.apply("green", 10L);
        Apple red = biFunction.apply("red", 20L);
        List<Apple> apples = Arrays.asList(green, red);
//        apples.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.com;
//            }
//        });

    }
}
