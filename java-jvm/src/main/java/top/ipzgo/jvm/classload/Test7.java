package top.ipzgo.jvm.classload;

public class Test7 {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Class.forName("top.ipzgo.jvm.classload.C").getClassLoader());

        System.out.println(Class.forName("java.lang.Object").getClassLoader());
    }
}

class C {

}