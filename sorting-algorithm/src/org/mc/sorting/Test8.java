package org.mc.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author machao
 * @date 2020-05-18
 */
public class Test8 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.set(2,999);
        list.remove(4);

        System.out.println(Arrays.toString(list.toArray()));
        int [] arr1=new int[109];
        for(int i=0;i<100;i++){
            arr1[i]=i;
        }
        System.out.println(Arrays.toString(arr1));
        System.arraycopy(arr1, 5, arr1, 5+1, 100-5);
        System.out.println(Arrays.toString(arr1));

    }

    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = true
                ? (T[]) new Object[newLength]
                : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }

}
