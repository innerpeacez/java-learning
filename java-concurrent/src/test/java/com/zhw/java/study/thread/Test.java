package com.zhw.java.study.thread;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String concurrent = "011";
        String spec = "000";
        two(concurrent, spec);
    }

    public static void two(String concurrent, String spec) {
        Assert.assertTrue("Cannot be greater than 30", concurrent.length() <= 30);
        String[] one = toArray(concurrent);
        String[] two = toArray(spec);
        if (one.length != two.length) {
            System.out.println("impossible");
            return;
        }

        Integer[] concurrentInts = toIntegers(one);
        Integer[] specInts = toIntegers(two);
        Integer count = 0;

        for (int i = 0; i < concurrentInts.length - 1; i++) {
            // 最后
            if (i == concurrentInts.length - 2) {
                if (concurrentInts[i] != specInts[i]) {
                    count++;
                    concurrentInts[concurrentInts.length - 2] = swap(concurrentInts[concurrentInts.length - 2]);
                    concurrentInts[concurrentInts.length - 1] = swap(concurrentInts[concurrentInts.length - 1]);
                }
            }

            // 第一个位置和中间位置
            if (concurrentInts[i] != specInts[i]) {
                count++;
                concurrentInts[i] = swap(concurrentInts[i + 1]);
                concurrentInts[i + 1] = swap(concurrentInts[i + 1]);
                concurrentInts[i + 2] = swap(concurrentInts[i + 2]);
            }
        }

        if (Arrays.toString(concurrentInts).equals(Arrays.toString(specInts))) {
            System.out.println(count);
        } else {
            System.out.println("impossible");
        }
    }

    public static Integer[] toIntegers(String[] strs) {
        Integer[] num = new Integer[strs.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(strs[i]);
        }
        return num;
    }

    public static Integer swap(Integer num) {
        if (num == 0) {
            num = 1;
        }
        if (num == 1) {
            num = 0;
        }
        return num;
    }

    public static String[] toArray(String str) {
        return str.split("");
    }


    private static final String str = "If not now, when? if not me, who?";

    public static void printWordsCount() {
        Map<String, Integer> map = new LinkedHashMap<>();
        Integer count = 1;
        String[] split = str.toLowerCase().split("\\W+");

        for (String word : split) {
            if (map.get(word) != null && map.get(word) != 0) {
                count++;
            }
            map.put(word, count);
            count = 1;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s %d\n", entry.getKey(), entry.getValue());
        }
    }

}
