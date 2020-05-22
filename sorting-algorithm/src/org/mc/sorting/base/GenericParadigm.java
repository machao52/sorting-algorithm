package org.mc.sorting.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author machao
 * @date 2020-05-20
 * <p>
 * 泛型
 */
public class GenericParadigm<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericParadigm(T value) {
        this.value = value;
    }

    public GenericParadigm() {
    }

    public static void show(GenericParadigm<Number> genericParadigm) {
        System.out.println(genericParadigm.getValue());
    }

    public static void showCommon(GenericParadigm<?> genericParadigm) {
        System.out.println(genericParadigm.getValue());
    }

    public static void showCommon2(GenericParadigm<? extends Number> genericParadigm) {
        System.out.println(genericParadigm.getValue());
    }

    public <T> T showCommon3(GenericParadigm<? extends T> genericParadigm) {
        System.out.println(genericParadigm.getValue());
        return genericParadigm.getValue();
    }

    /**
     * 带<T>才是泛型方法
     *
     * @param genericParadigm
     * @param <T>
     * @return
     */
    public <T> T showMethod(GenericParadigm<T> genericParadigm) {
        return genericParadigm.getValue();
    }

    public <E> void showMethod33(E genericParadigm) {

    }

    public <T> T showMethod9(T user) {
        return user;
    }

    /**
     * 在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
     *
     * @param genericParadigm
     * @param <T>
     * @return
     */
    public <T extends Number> T showMethod1(GenericParadigm<T> genericParadigm) {
        return genericParadigm.getValue();
    }

    public <T extends Number, K, E> T showMethod2(GenericParadigm<T> genericParadigm, K original) {
        return genericParadigm.getValue();
    }


    public void showKey(GenericParadigm<T> genericParadigm) {

    }

    public T show_1(T t) {
        return t;
    }

    public <T> T show_2(T t) {
        return t;
    }

    public <E> E show_3(E e) {
        return e;
    }

    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println(t + " ");
        }
    }

    public GenericParadigm<? extends Number> show_9(GenericParadigm<? extends Number> t) {
        return t;
    }

    public <E extends Number> E show_5(E t) {
        return t;
    }


    public <T> void add(Father<? super Father> para) {
        para.add(new Father());
    }


    /**
     * 静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T method(T t) {
        return t;
    }

    public void testWords(Collection collection) {
        collection.size();
        collection.add("ab1");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Integer integer = new Integer(33);
        StringTest stringTest = new StringTest();
        GenericParadigm<Integer> genericParadigm1 = new GenericParadigm<>();
        GenericParadigm<Number> genericParadigm2 = new GenericParadigm<>();
        GenericParadigm<String> genericParadigm3 = new GenericParadigm<>();
        showCommon2(genericParadigm1);
        genericParadigm2.show_1(integer);
        //genericParadigm2.show_1(stringTest);

        genericParadigm2.show_2(stringTest);
        genericParadigm2.show_3(stringTest);
        genericParadigm2.printMsg(2, "哈哈", true, 9.99);
        method(stringTest);
        genericParadigm2.show_9(genericParadigm2);
        genericParadigm2.showCommon3(genericParadigm3);
        List<String>[] arrayLists = new ArrayList[10];
        /*Object o = arrayLists;
        Object[] oa = (Object[]) o;
        List<Integer> list=new ArrayList<>();
        list.add(Integer.valueOf(99));
        oa[0]=list;
        String s=arrayLists[0].get(0);
        System.out.println(s);*/

        List<?>[] lists = new List<?>[10];
        Object o = lists;
        Object[] oa = (Object[]) o;
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(88));
        List<String> list2 = new ArrayList<>();
        list2.add("hh");
        oa[0] = list;
        lists[1] = list2;
        Integer a = (Integer) lists[0].get(0);
        String b = (String) lists[1].get(0);
        System.out.println(a + " " + b);

        //有人说，<?>提供了只读的功能，也就是它删减了增加具体类型元素的能力，只保留与具体类型无关的功能。
        // 它不管装载在这个容器内的元素是什么类型，它只关心元素的数量、容器是否为空？我想这种需求还是很常见的吧。
        /*List<?> wildlist = new ArrayList<String>();
        wildlist.add(null);
        wildlist.add("123");*/

        //利用反射绕过泛型
        List<String> strList = new ArrayList<>();
        strList.add("abc123");
        Method method = strList.getClass().getDeclaredMethod("add", Object.class);
        method.invoke(strList, 123);
        method.invoke(strList, true);
        System.out.println(Arrays.toString(strList.toArray()));
    }

}
