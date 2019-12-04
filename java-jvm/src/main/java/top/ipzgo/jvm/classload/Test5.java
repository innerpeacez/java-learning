package top.ipzgo.jvm.classload;

import java.util.Random;

public class Test5 {
    public static void main(String[] args) {
        System.out.println(Child5.b);
    }
}

interface Parent5 {
    int a = new Random().nextInt(1);
}

interface Child5 extends Parent5 {
    int b = 6;
}

