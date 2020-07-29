package top.ipzgo.jvm.classload;

public class Test6 {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getSingleton();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);

        Singleton singleton1 = new Singleton();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}

class Singleton {
    public static int counter1;

    public static Singleton singleton = new Singleton();

    public Singleton() {
        counter1++;
        counter2++;

        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getSingleton() {
        return singleton;
    }
}