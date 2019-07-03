package com.zhw.java.study.example;

import com.zhw.java.study.pojo.student.Student;
import lombok.NonNull;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StudentsTest {

    static volatile List<Student> students = Arrays.asList(
            new Student("zhangsan", 10, "male", "basketball"),
            new Student("lisi", 11, "male", "volleyball"),
            new Student("wangwu", 12, "male", "volleyball"),
            new Student("zhaoliu", 13, "male", "basketball"),
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

    /**
     * 找出年龄最大的三个人
     */
    @Test
    public void streamLimit() {
        List<Student> limit3students = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limit3students);
    }

    /**
     * 找出三个最大的男生
     */
    @Test
    public void streamFilterAndLimit() {
        List<Student> maleMax3 = students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .filter(student -> student.getSex().equals("male"))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(maleMax3);
    }

    /**
     * 找出所有的男同学并去重
     */
    @Test
    public void streamDistinct() {
        List<Student> maleMax3 = students.stream()
                .filter(student -> student.getSex().equals("male"))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(maleMax3);
    }

    /**
     * 找出男同学和女同学的数量
     */
    @Test
    public void streamCount() {
        long countMale = students.stream()
                .filter(student -> "male".equals(student.getSex()))
                .distinct()
                .count();
        long countFemale = students.stream()
                .filter(student -> "female".equals(student.getSex()))
                .distinct()
                .count();
        System.out.printf("male count : %d , female count : %d", countMale, countFemale);
    }

    /**
     * 跳过前三个人
     */
    @Test
    public void streamSkip() {
        List<Student> minAgeStudent = students.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(minAgeStudent);
    }

    /**
     * reduce 计算年龄总和
     */
    @Test
    public void testReduce() {
        OptionalInt sumAge = students.parallelStream()
                .mapToInt(Student::getAge)
                .reduce(Integer::sum);
        System.out.printf("sumAge: %d", sumAge.orElse(0));
    }

    @Test
    public void testReduceMax() {
        OptionalInt maxAge = students.stream()
                .mapToInt(Student::getAge)
                .reduce(Integer::max);
        System.out.printf("max age = %d", maxAge.orElse(0));
    }
}
