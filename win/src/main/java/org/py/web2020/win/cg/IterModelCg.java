package org.py.web2020.win.cg;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.py.web2020.win.IterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class IterModelCg implements MethodInterceptor {
    private final Logger log = LoggerFactory.getLogger(IterModelCg.class);
    private Enhancer enhancer;

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IterModel.class);
        enhancer.setCallback(new IterModelCg());
        IterModel iterModel = (IterModel) enhancer.create();
        iterModel.forEach(System.out::println);
    }

    public IterModelCg() {
        enhancer = new Enhancer();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("AOP切面开始");
        Object result = methodProxy.invokeSuper(object, args);
        return result;
    }

    public Object getBean(Class cls) {
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
