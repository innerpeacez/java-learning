package com.zhw.java.study.lambda;

import com.zhw.java.study.pojo.Letter;
import org.junit.Test;

import java.util.function.Function;

public class LambdaComplexTest {

    @Test
    public  void complex() {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> one = addHeader;
        String lambda = one.apply("labda");
        System.out.println(lambda);
        Function<String, String> second = addHeader.andThen(Letter::checkSpelling);
        String apply = second.apply(lambda);
        System.out.println(apply);
        Function<String, String> tri = addHeader.compose(Letter::addFooter);
        String apply1 = tri.apply(apply);
        System.out.println(apply1);
    }
}
