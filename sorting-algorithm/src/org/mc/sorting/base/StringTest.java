package org.mc.sorting.base;

/**
 * @author machao
 * @date 2020-05-20
 */
public class StringTest {


    public static void test1() {
        String s1 = "ab123";
        String s2 = "ab123";
        System.out.println("test1的结果为：" + (s1 == s2));
    }

    public static void test2() {
        String s1 = new String("ab123");
        String s2 = "ab123";
        System.out.println("test2的结果为：" + (s1 == s2));
    }

    public static void test3() {
        String s1 = new String("ab123");
        String s2 = "ab123";
        s1 = s1.intern();
        System.out.println("test3的结果为：" + (s1 == s2));
    }

    public static void test4() {
        String s1 = "abc123";
        String s2 = "abc" + "123";
        System.out.println("test4的结果为：" + (s1 == s2));
    }

    public static void test5() {
        String s1 = "abc123";
        String a = "123";
        String s2 = "abc" + a;
        System.out.println("test5的结果为：" + (s1 == s2));
    }

    public static void test6() {
        String s1 = "abc123";
        String a = "123";
        String s2 = "abc" + a;
        s2 = s2.intern();
        System.out.println("test6的结果为：" + (s1 == s2));
    }


    public static void test7() {
        String s1 = "abc123";
        String a = new String("123");
        String s2 = "abc" + a;
        System.out.println("test7的结果为：" + (s1 == s2));
    }

    public static void test8() {
        String s1 = "abc123";
        String a = new String("123");
        String s2 = "abc" + a;
        s2 = s2.intern();
        System.out.println("test8的结果为：" + (s1 == s2));
    }

    public static void test9() {
        String s1 = "abc123";
        String s2 = "abc" + getA();
        System.out.println("test9的结果为：" + (s1 == s2));
    }

    public static String getA() {
        return "123";
    }

    public static void test10() {
        String s1 = "abc123";
        String s2 = "abc" + getA();
        s2 = s2.intern();
        System.out.println("test10的结果为：" + (s1 == s2));
    }

    public static void test11() {
        String s1 = "abc123";
        final String a = "123";
        String s2 = "abc" + a;
        System.out.println("test11的结果为：" + (s1 == s2));
    }

    public static void test12() {
        String s1 = new String("abc123");
        String s2 = new String("abc123");
        s1 = s1.intern();
        s2 = s2.intern();
        System.out.println("test12的结果为：" + (s1 == s2));
    }

    public static void test13() {
        String s1 = new String("abc123");
        String s2 = s1.intern();
        System.out.println("test13的结果为：" + (s1 == s2));
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        String str = new String();
        System.out.println(str.equals(""));
        System.out.println(args.length);
    }

}
