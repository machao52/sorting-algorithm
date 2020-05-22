package org.mc.sorting;

/**
 * @author machao
 * @date 2020-05-20
 */
public class Test9 {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }


}

class MyClass {

    void changeValue(StringBuffer stringBuffer) {
        stringBuffer = new StringBuffer("world");
    }

}
