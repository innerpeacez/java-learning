package com.zhw.java.study.example;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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

    /**
     * 由值创建流
     */
    @Test
    public void valueStream() {
        Stream<String> my = Stream.of("My", "name", "is", "innerpeacez");
        String myName = my.collect(Collectors.joining(" ", "", "."));
        System.out.println(myName);
    }


    /**
     * 创建空流
     */
    @Test
    public void emptyStream() {
        Stream<Object> empty = Stream.empty();
    }

    /**
     * 数组创建流
     */
    @Test
    public void arrayStream() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream stream = Arrays.stream(numbers);
        System.out.println(stream.sum());
    }

    /**
     * 文件流
     */
    @Test
    public void fileStream() {
        try (Stream<String> lines = Files.lines(Paths.get("java-8/src/main/resources/data.txt"), Charset.defaultCharset())) {
            lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}