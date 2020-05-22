package org.mc.sorting.base.innerClass;

/**
 * @author machao
 * @date 2020-05-21
 */
public class OutTest {

    public static void main(String[] args) {
        Out out=new Out();
        out.setAge(55);
        Out.Inner inner=out.new Inner();
        inner.printOutAge();
    }

}
