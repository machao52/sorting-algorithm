package org.mc.sorting.base.annotation;

import sun.reflect.CallerSensitive;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author machao
 * @date 2020-05-22
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

    int id();

    String msg() default "hehe";

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Perform {
        int dex();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Perform1 {
    }


    @TestAnnotation(id = 23232, msg = "xixi")
    class Test {

        @Check("123")
        private int age;

        @Deprecated
        public void hello() {

        }

        @SuppressWarnings("")
        public void hello1() {
            Test test = new Test();
            test.hello();
        }

        @Perform(dex = 999)
        @Perform1
        public void method() {
            int a = 0;
            int b = 1;
        }

        public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
            boolean flag = Test.class.isAnnotationPresent(TestAnnotation.class);
            boolean flag1 = TestAnnotation.class.isAnnotation();
            System.out.println(flag + " " + flag1);
            if (flag) {
                //类注解
                TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
                System.out.println("id: " + testAnnotation.id() + " msg：" + testAnnotation.msg());
            }

            //成员属性注解
            Field field = Test.class.getDeclaredField("age");
            field.setAccessible(true);
            Check check = field.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("check value：" + check.value());
            }

            //方法注解
            Method method = Test.class.getDeclaredMethod("method");
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("method list: "+annotation.annotationType().getSimpleName());
            }
            Perform perform = method.getAnnotation(Perform.class);
            System.out.println("perform dex: " + perform.dex());
        }

    }
}


