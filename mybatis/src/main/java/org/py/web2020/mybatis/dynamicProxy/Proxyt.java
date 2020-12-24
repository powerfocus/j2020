package org.py.web2020.mybatis.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxyt {
    private Long id;
    private String name;
    public static interface ProxiedInterface {
        void proxy();
    }
    public static class Invohandler implements InvocationHandler {
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            System.out.println("动态代理方法开始...");
            System.out.println(method.getName());
            System.out.println(o.getClass().getName());
            System.out.println(objects.length);
            System.out.println("动态代理方法结束");
            return null;
        }
    }

    public static void main(String[] args) {
        InvocationHandler ih = new Invohandler();
        ProxiedInterface proxy = (ProxiedInterface)Proxy.newProxyInstance(Proxyt.class.getClassLoader(),
                new Class[] {ProxiedInterface.class}, ih);
        proxy.proxy();
    }
}
