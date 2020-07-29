package com.zhw.java.study.pojo.apple;

import java.util.ArrayList;
import java.util.List;

public class Filter<T> {

    public List<T> filter(List<T> list, Predicate<T> predicate) {
        ArrayList<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
