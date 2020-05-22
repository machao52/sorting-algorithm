package org.mc.sorting.base;

/**
 * @author machao
 * @date 2020-05-22
 */
public class IntegerTest {

    public static void main(String[] args) {
        int a = 23;
        Integer b = new Integer(23);
        Integer d = new Integer(23);
        Integer e = new Integer(128);

        Integer f = 23;
        Integer g = 23;

        Integer h = 128;
        Integer i = 128;
        int j = 128;

        Integer l = Integer.valueOf("45");
        Integer m = Integer.valueOf(45);

        Integer o = Integer.valueOf("454");
        Integer p = Integer.valueOf(454);
        System.out.println(a == b);
        System.out.println(b == d);
        System.out.println(b == f);
        System.out.println(f == g);
        System.out.println(h == i);
        System.out.println(e == j);
        System.out.println(l == m);
        System.out.println(o == p);


    }
}
