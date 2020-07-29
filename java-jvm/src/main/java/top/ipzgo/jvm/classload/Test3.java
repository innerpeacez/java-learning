package top.ipzgo.jvm.classload;

import java.util.UUID;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(Parent3.str1);
    }
}

class Parent3 {

    public static final String str1 = UUID.randomUUID().toString();


    static {
        System.out.println("Parent static block.");
    }
}
