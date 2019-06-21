package com.zhw.java.study.pojo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Student {

    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String sex;
    private String hobby;

}
