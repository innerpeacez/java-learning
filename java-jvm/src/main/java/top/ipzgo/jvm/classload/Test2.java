package top.ipzgo.jvm.classload;

public class Test2 {

    public static void main(String[] args) {
//        System.out.println(Parent2.str1);
        System.out.println(Parent2.s);
    }
}

class Parent2 {

    public static final String str1 = "parent";

    public static final int s = 1;

    static {
        System.out.println("Parent static block.");
    }
}
