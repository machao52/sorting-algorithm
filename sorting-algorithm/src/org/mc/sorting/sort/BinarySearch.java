package org.mc.sorting.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author machao
 * @date 2020-03-20
 * <p>
 * 二分查找
 */
public class BinarySearch {


    /**
     * 找到等于传入的值
     *
     * @param array
     * @param low
     * @param high
     * @param num
     * @return
     */
    public static int binarySearch(int[] array, int low, int high, int num) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (num == array[mid]) {
            return mid;
        } else if (num < array[mid]) {
            return binarySearch(array, low, mid - 1, num);
        } else {
            return binarySearch(array, mid + 1, high, num);
        }
    }

    /**
     * 找到第一个等于传入的值
     *
     * @param array
     * @param low
     * @param high
     * @param num
     * @return
     */
    public static int firstEqBinarySearch(int[] array, int low, int high, int num) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (num == array[mid] && (mid == 0 || array[mid - 1] != num)) {
            return mid;
        } else if (num > array[mid]) {
            return firstEqBinarySearch(array, mid + 1, high, num);
        } else {
            return firstEqBinarySearch(array, low, mid - 1, num);
        }
    }

    /**
     * 找到第一个大于等于传入的值
     *
     * @param array
     * @param low
     * @param high
     * @param num
     * @return
     */
    public static int firstGtBinarySearch(int[] array, int low, int high, int num) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (num <= array[mid]) {
            if (mid == 0 || array[mid - 1] < num){
                return mid;
            }else{
                return firstGtBinarySearch(array, low, mid - 1, num);
            }

        } else {
            return firstGtBinarySearch(array, mid+1, high, num);
        }
    }

    /**
     * 找到第一个小于等于传入的值
     *
     * @param array
     * @param low
     * @param high
     * @param num
     * @return
     */
    public static int firstLtBinarySearch(int[] array, int low, int high, int num) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (num >= array[mid]) {
            if (mid == array.length - 1 || array[mid + 1] > num) {
                return mid;
            } else {
                return firstLtBinarySearch(array, mid + 1, high, num);
            }
        } else {
            return firstLtBinarySearch(array, low, mid - 1, num);

        }
    }


    public static void main(String[] args) {

        int[] array = {1, 34, 78, 78, 78, 92, 109, 201, 288, 399, 477, 499};

        int num = 36;

        int index = firstGtBinarySearch(array, 0, array.length - 1, num);
        System.out.println(index);
    }

}
