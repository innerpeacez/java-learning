package com.zhw.java.study.example;

import com.zhw.java.study.pojo.student.Student;
import lombok.NonNull;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployTest {

    static volatile List<Student> students = Arrays.asList(
            new Student("zhangsan", 10, "male", "basketball"),
            new Student("lisi", 11, "male", "volleyball"),
            new Student("wangwu", 12, "male", "volleyball"),
            new Student("zhaoliu", 13, "male", "basketball"),
            new Student("xiaoming", 14, "male", "basketball"),
            new Student("xiaohua", 15, "male", "violin"),
            new Student("xiaoli", 16, "female", "violin"),
            new Student("xiaohong", 17, "female", "violin"),
            new Student("xiaoai", 18, "female", "piano")
    );

    /**
     * 查询学生的名字列表
     */
    @Test
    public void streamNames() {
        List<@NonNull String> names = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(names);
    }

    /**
     * 查询学生的总年龄
     */
    @Test
    public void streamAges() {
        int ages = students.stream()
                .map(Student::getAge)
                .mapToInt(age -> age)
                .sum();
        System.out.println("总年龄 = " + ages);
    }

    /**
     * 找出所有喜喜欢篮球的同学
     */
    @Test
    public void streamHobby() {
        List<Student> basketballPeople = students.stream()
                .filter(student -> student.getHobby().equals("basketball"))
                .collect(Collectors.toList());
        System.out.println(basketballPeople);
    }

    /**
     * 查找年龄大于15岁的学生
     */
    @Test
    public void streamFilter() {
        List<Student> upThan15 = students.stream()
                .filter(student -> student.getAge() > 15)
                .collect(Collectors.toList());
        System.out.println(upThan15);
    }

    /**
     * 根据学生年龄正序
     */
    @Test
    public void streamSort() {
        List<Student> collect = students.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 根据学生年龄倒序
     */
    @Test
    public void streamSortDesc() {
        List<Student> collect = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
