package com.zhw.java.study.stream;

import com.zhw.java.study.pojo.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 1120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    @Test
    public void testStream() {
        Stream<Dish> dishStream = menu.stream();
        long count = dishStream
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .count();
//        List<String> collect = (List<String>) count
//                .collect(Collectors.toList()).stream()
//                .filter(name -> name.equals("beef"))
//                .collect(Collectors.toList());

        System.out.println(count);

        menu.forEach(System.out::println);
        System.out.println("---------------");
        menu.parallelStream().forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        integers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);


    }

    @Test
    public void testWords() {
        List<String> words = Arrays.asList("Java 8", "In", "Action");
        words.stream()
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void dishNameLength() {
        menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void testGetDiffChart() {
        List<String> words = Arrays.asList("HELLO", "WORLD");
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList()).stream()
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void testSquare() {
        Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(num -> num * num)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


    @Test
    public void testDuishu() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list1 = Arrays.asList(3, 4);
        list.stream()
                .flatMap(i -> list1.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

    }

    @Test
    public void testDuishu2() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list1 = Arrays.asList(3, 4);
        list.stream()
                .flatMap(i -> list1.stream()
                        .filter(j -> (i + j) % 2 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());


    }

    @Test
    public void firstNum3() {
        Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(num -> num * num)
                .filter(num -> num % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
