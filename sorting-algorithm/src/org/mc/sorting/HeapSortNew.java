package org.mc.sorting;

import java.util.Arrays;

/**
 * @author machao
 * @date 2020-04-02
 * <p>
 * 堆排序
 */
public class HeapSortNew {

    /**
     * 构建大顶堆
     *
     * @param array
     */
    public static void maxHeap(int[] array) {
        for (int i = (array.length - 2); i >= 0; i--) {
            moveNode(array, i, array.length - 1);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            moveNode(array, 0, i - 1);
        }

    }

    /**
     * 比较以后，移动节点
     */
    public static void moveNode(int[] array, int current, int length) {
        int temp = array[current];
        for (int y = 2 * current + 1; y <= length; y = 2 * y + 1) {
            if (y < length && array[y] < array[y + 1]) {
                y++;
            }
            if (temp > array[y]) {
                break;
            }
            array[current] = array[y];
            current = y;
        }
        array[current] = temp;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public static void main(String[] args) {
        int[] array = {7, 5, 19, 8, 4, 4, 1, 20, 13, 16};
        maxHeap(array);
        System.out.println(Arrays.toString(array));
    }

}
