package com.zhw.java.study.agent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class SkyWalkingTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println(className);

        if (!"com.zhw.java.study.App".equals(className)) {
            return null;
        }

        ClassPool cp = ClassPool.getDefault();

        try {
            CtClass ctClass = cp.getCtClass(className.replace("/", "."));
            CtMethod method = ctClass.getDeclaredMethod("main");
            method.addLocalVariable("beginTime", CtClass.longType);

            method.insertBefore("long beginTime = System.currentTimeMillis();");
            method.insertAfter("System.out.printf(\"doing time:%d\", System.currentTimeMillis() - beginTime);");
            return ctClass.toBytecode();
        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
