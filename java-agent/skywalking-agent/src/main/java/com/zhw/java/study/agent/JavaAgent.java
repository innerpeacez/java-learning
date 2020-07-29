package com.zhw.java.study.agent;

import java.lang.instrument.Instrumentation;

public class JavaAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("This is javaagent demo");
        instrumentation.addTransformer(new SkyWalkingTransformer());
    }

    public static void premain(String args) {
        System.out.println("This is javaagent demo");
    }
}
