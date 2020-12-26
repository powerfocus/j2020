package org.py.web2020.hibernate;

import javax.tools.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Rel {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        String className = "Hello";
        String methodName = "sayHello";
        String source = "public class Hello {public Hello() {System.out.println(\"这是一个代码生成的类 默认构造函数\");}" +
                " public String sayHello() {return \"这是一个自动生成的类！\";} " +
                "@Override public String toString() {return \"这是一个自动生成的类！\";}}";
        SimpleJavaFileObject javaFileObject = new JavaSourceFromString(className, source);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(new DiagnosticCollector<>(), null, null);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null,
                Arrays.asList("-d", "hibernate/target/classes/"), null, Arrays.asList(javaFileObject));
        if (task.call()) {
            Object obj = Class.forName(className).getDeclaredConstructor().newInstance();
            Method method = obj.getClass().getMethod("toString");
            System.out.println(method.invoke(obj));
            Method sayHiMethod = obj.getClass().getMethod(methodName);
            System.out.println(sayHiMethod.invoke(obj));
        } else {
            System.out.println("类生成失败");
        }
        fileManager.close();
    }
}