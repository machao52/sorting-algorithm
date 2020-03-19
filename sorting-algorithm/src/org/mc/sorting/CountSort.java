package org.mc.sorting;

import java.util.Arrays;

/**
 * @author machao
 * @date 2020-03-18
 * <p>
 * 计数排序，数据必须是正整数
 */
public class CountSort {

    public static void countSort(int[] array) {

        //找到最大值，建立索引数组
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] indexArray = new int[max + 1];

        //统计原始数组的数量到索引数组当中
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            indexArray[value] = indexArray[value] + 1;
        }

        //累加索引数组
        int sum = 0;
        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = indexArray[i] + sum;
            sum = indexArray[i];
        }

        //开始排序
        int[] tmp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int index = indexArray[value];
            tmp[index - 1] = value;
            indexArray[value]--;
        }

        //临时数组复制到原数组
        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 1, 2, 2, 3, 5, 4, 2, 2, 4, 2, 1, 5, 4,
                6, 3, 2, 4, 1, 2, 3, 4, 2, 1, 5, 3, 2, 4, 1, 3, 2, 1, 2, 3, 5, 2, 1, 3, 2, 1, 2, 3};
        countSort(array);
        System.out.println(Arrays.toString(array));

    }

}
