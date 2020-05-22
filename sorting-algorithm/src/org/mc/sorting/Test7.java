package org.mc.sorting;

import org.mc.sorting.sort.Numbers;

import java.util.Arrays;

/**
 * @author machao
 * @date 2020-03-19
 */
public class Test7 {

    public static void bubbleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array.length - 1 - i; y++) {
                if (array[y] > array[y + 1]) {
                    int tmp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = tmp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int y = i - 1;
            for (; y >= 0; y--) {
                if (value < array[y]) {
                    array[y + 1] = array[y];
                } else {
                    break;
                }
            }
            array[y + 1] = value;
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i + 1;
            int y = i + 1;
            for (; y < array.length; y++) {
                if (array[y] < array[index]) {
                    index = y;
                }
            }
            if (index != y) {
                int tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] array1 = new int[]{1, 4, 9, 7};
        long start = System.currentTimeMillis();
        int[] array = Numbers.NUMBERS;
        selectSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(System.currentTimeMillis() - start);
    }

}
