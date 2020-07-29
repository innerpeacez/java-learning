package top.ipzgo.jvm.classload;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(Child.str1);
    }
}

class Parent {

    public static final String str1 = "parent";

    static {
        System.out.println("Parent static block.");
    }
}


class Child extends Parent {

    public static final String str2 = "child";

    static {
        System.out.println("Child static block.");
    }
}