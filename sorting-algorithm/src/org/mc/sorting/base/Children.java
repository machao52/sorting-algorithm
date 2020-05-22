package org.mc.sorting.base;

/**
 * @author machao
 * @date 2020-05-21
 */
public class Children<E> extends Father<E> {


    @Override
    public void add(E e){

    }

    public static void main(String[] args) {
        Father father=new Father();
        father.add("123");
        Children children=new Children();
        children.add("56");
    }

}
