package com.zhw.java.study.lambda;


import com.zhw.java.study.pojo.apple.Apple;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaConstructorTest {

    @Test
    public void testLambdaNoArgsConstructor() {
        Supplier<Apple> supplier = Apple::new;
        Apple apple = supplier.get();
        System.out.println(apple);
    }

    @Test
    public void testLambdaOneArgsConstructor() {
        Function<Long,Apple> function = Apple::new;
        Apple apple = function.apply(10L);
        System.out.println(apple);
    }


    @Test
    public void testLambdaMultiArgsConstructor() {
        BiFunction<String,Long,Apple> function = Apple::new;
        Apple apple = function.apply("green",10L);
        System.out.println(apple);
    }


}
