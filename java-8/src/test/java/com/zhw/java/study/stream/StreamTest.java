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
}
