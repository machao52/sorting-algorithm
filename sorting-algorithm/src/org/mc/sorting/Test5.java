package org.mc.sorting;

import org.mc.sorting.sort.Numbers;

import java.util.Arrays;

/**
 * @author machao
 * @date 2020-03-16
 * 归并排序
 */
public class Test5 {

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = (s + e) / 2;
        mergeSort(array, s, mid);
        mergeSort(array, mid + 1, e);
        merge(array, s, mid, e);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[array.length];
        int p1 = left;
        int p2 = mid + 1;
        int k = left;
        while (p1 <= mid && p2 <= right) {
            if (array[p1] <= array[p2]) {
                tmp[k++] = array[p1++];
            } else {
                tmp[k++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            tmp[k++] = array[p1++];
        }
        while (p2 <= right) {
            tmp[k++] = array[p2++];
        }
        for (int i = left; i <= right; i++) {
            array[i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int[] array = Numbers.NUMBERS;
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
