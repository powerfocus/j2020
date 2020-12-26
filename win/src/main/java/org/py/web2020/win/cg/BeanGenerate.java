package org.py.web2020.win.cg;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanGenerate {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name", String.class);
        beanGenerator.addProperty("age", Integer.class);
        Object obj = beanGenerator.create();
        Method setNameMethod = obj.getClass().getMethod("setName", String.class);
        setNameMethod.invoke(obj, "win10");
        Method getNameMethod = obj.getClass().getMethod("getName");
        System.out.println(getNameMethod.invoke(obj));
    }
}
