package org.mc.sorting.base.innerClass;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * @author machao
 * @date 2020-05-21
 */
public class Out {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 成员内部类
     */
    class Inner {
        private int count;

        public void printOutAge() {
            System.out.println(age);
        }

        public void printInnerCount() {
            System.out.println(count);
        }
    }


    /**
     * 局部内部类
     */
    public IOut getValue(String value) {
        class Inner2 implements IOut {

            private String value;

            public Inner2(String value) {
                this.value = value;
            }

            @Override
            public String getValue(String str) {
                return this.value + " " + str;
            }
        }
        return new Inner2(value);
    }

    /**
     * 匿名内部类
     * @param values
     * @return
     */
    public IOut getValue2(String values) {
        return new IOut() {
            private String value;

            @Override
            public String getValue(String str) {
                return values + " " + str;
            }
        };
    }

    /**
     * 静态内部类
     */
    public static class Inner3 {

        private int ab;

        public Inner3() {

        }

        public Inner3(int value) {
            this.ab = value;
        }

        public void getValues3(String a) {
            System.out.println(ab+" "+a);
        }
    }


    public static void main(String[] args) {
        Out out = new Out();
        out.setAge(55);
        Inner inner = out.new Inner();
        inner.printOutAge();

        IOut out1 = out.getValue("呼呼");
        System.out.println(out1.getValue("11"));

        IOut out2 = out.getValue2("呵呵");
        System.out.println(out2.getValue("99"));

        Inner3 inner3 = new Out.Inner3(123);
        inner3.getValues3("嘻嘻");

        IOut.PrintOut printOut=new IOut.PrintOut();
        printOut.getValue("ss");
    }
}
