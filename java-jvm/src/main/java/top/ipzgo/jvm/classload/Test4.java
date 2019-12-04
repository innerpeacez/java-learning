package top.ipzgo.jvm.classload;

import java.util.UUID;

public class Test4 {
    public static void main(String[] args) {

        Parent4[] parent4s = new Parent4[1];
        System.out.println(parent4s.getClass());
        System.out.println(parent4s.getClass().getSuperclass());

        byte[] bytes = new byte[1];
        short[] shorts = new short[1];
        int[] ints = new int[1];
        char[] chars = new char[1];
        long[] longs = new long[1];
        float[] floats = new float[1];
        double[] doubles = new double[1];
        boolean[] booleans = new boolean[1];

        System.out.println("booleans --> " + booleans.getClass());
        System.out.println("doubles --> " + doubles.getClass());
        System.out.println("floats --> " + floats.getClass());
        System.out.println("longs --> " + longs.getClass());
        System.out.println("chars --> " + chars.getClass());
        System.out.println("ints --> " + ints.getClass());
        System.out.println("shorts --> " + shorts.getClass());
        System.out.println("bytes --> " + bytes.getClass());
    }
}

class Parent4 {

    public static final String str1 = UUID.randomUUID().toString();

    static {
        System.out.println("Parent static block.");
    }
}

