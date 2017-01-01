package org.mc.sorting;

import java.util.Arrays;

/**
 * 简单选择排序
 * @author machao
 * Created in 2016/12/31
 * 时间复杂度为O[n^2]
 * 性能上略优于冒泡排序
 */
public class SelectSort {
	
	public static void selectSort(int [] numbers){
		
		int min;//最小值的下标
		for(int i=0;i<numbers.length-1;i++){
			min=i;
			for(int y=i+1;y<numbers.length;y++){
				if(numbers[min]>numbers[y]){
					min=y;
				}
			}
			if(i!=min){
				swap(numbers,i,min);
			}
		}
	}
	
	/**
	 * 交换位置
	 */
	public static void swap(int [] numbers,int i,int y){
		int temp=0;
		temp=numbers[i];
		numbers[i]=numbers[y];
		numbers[y]=temp;
	}
	
	public static void main(String[] args) {
		int [] numbers = Numbers.NUMBERS2;
		long startTime = System.nanoTime();
		selectSort(numbers);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	}

}
