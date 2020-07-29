package top.ipzgo.jvm.classload;

import java.util.Random;

public class Test5 {
    public static void main(String[] args) {
        System.out.println(Z.z);
    }
}

interface Parent5 {

    Object object = new Object() {
        {
            System.out.println("parent.");
        }
    };
}

interface Child5 extends Parent5 {

    int c = new Random().nextInt();

    Object object = new Object() {
        {
            System.out.println("child.");
        }
    };
}

class Z implements Child5 {

    static int z = 5;
}

