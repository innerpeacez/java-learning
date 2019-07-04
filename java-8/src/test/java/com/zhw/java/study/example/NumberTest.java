package com.zhw.java.study.example;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.stream.IntStream;


public class NumberTest {

    /**
     * 不包含20
     */
    @Test
    public void range() {
        IntStream.range(1, 20).forEach(System.out::println);
    }

    /**
     * 包含20
     */
    @Test
    public void rangeClosed() {
        IntStream.rangeClosed(1, 20).forEach(System.out::println);
    }

    /**
     * 勾股数
     */
    @Test
    public void gougu() {
        IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                )
                .forEach(t -> System.out.println(MessageFormat.format("[{0}, {1}, {2}]", t[0], t[1], t[2])));
    }
}