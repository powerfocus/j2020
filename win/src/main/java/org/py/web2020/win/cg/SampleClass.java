package org.py.web2020.win.cg;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SampleClass {
    public void info() {
        System.out.println("SampleClass info()");
    }
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before method...");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after method...");
            return result;
        });
        SampleClass sampleClass = (SampleClass) enhancer.create();
        sampleClass.info();
    }
}
