package org.mc.sorting.base;

/**
 * @author machao
 * @date 2020-05-22
 */
public class Reflex {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reflex() {

    }

    public Reflex(String name) {
        this.name = name;
        System.out.println("hello " + name);
    }

    public Reflex(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("hello " + name + " age:" + age);
    }

    private Reflex(int age) {
        this.age = age;
        System.out.println("age: " + age);
    }

    private String welcome(String trips) {
        System.out.println("trips: " + trips);
        return trips;
    }
}
