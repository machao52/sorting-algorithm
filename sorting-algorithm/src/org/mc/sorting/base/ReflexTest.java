package org.mc.sorting.base;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author machao
 * @date 2020-05-22
 */
public class ReflexTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = "abc123";
        Integer a = 12;
        String path = "java.util.ArrayList";
        Class clazz = name.getClass();
        Class clazz1 = Class.forName(path);
        System.out.println(a.getClass() + "  " + int.class);
        System.out.println(clazz);
        System.out.println(clazz1);

        Reflex reflex = new Reflex();
        Class reflexClazz = reflex.getClass();
        Constructor[] constructors = reflexClazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(Modifier.toString(constructor.getModifiers()) + " 参数: ");
            Class[] parameters = constructor.getParameterTypes();
            for (Class parameter : parameters) {
                System.out.print(parameter.getName() + " ");
            }
            System.out.println("");
        }

        Constructor constructor = reflexClazz.getDeclaredConstructor();
        System.out.println(Modifier.toString(constructor.getModifiers()) + "参数： " + Arrays.toString(constructor.getParameterTypes()));
        Constructor constructor1 = reflexClazz.getDeclaredConstructor(int.class, String.class);
        System.out.println(Modifier.toString(constructor1.getModifiers()) + "参数： " + Arrays.toString(constructor1.getParameterTypes()));

        Reflex reflex1 = (Reflex) constructor1.newInstance(21, "张三");
        Constructor constructor2 = reflexClazz.getDeclaredConstructor(int.class);
        constructor2.setAccessible(true);
        Reflex reflex2 = (Reflex) constructor2.newInstance(44);
        Method method = reflexClazz.getDeclaredMethod("welcome", String.class);
        method.setAccessible(true);
        method.invoke(reflex1, "旅行");

        Field[] fields = reflexClazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field: "+field.getName());
            field.setAccessible(true);
            System.out.println(field.get(reflex1));
        }

    }
}
