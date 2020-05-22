package org.mc.sorting;

import org.mc.sorting.sort.Numbers;

import java.util.Arrays;

/**
 * @author machao
 * @date 2020-03-17
 */
public class Test6 {


    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int s, int e) {
        if (s >= e) {
            return;
        }
        int p = partition(array, s, e);
        quickSort(array, s, p - 1);
        quickSort(array, p + 1, e);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i = i + 1;
            }
        }
        swap(array, i, right);
        return i;
    }

    public static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = Numbers.NUMBERS;
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
