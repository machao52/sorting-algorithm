package org.mc.sorting.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * @author machao
 * Created in 2016/12/31
 * 从第一个元素开始，该元素可以认为已经被排序  
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描  
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置  
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  
 * 将新元素插入到该位置中  
 * 重复步骤2
 * 事件复杂度为O[n^2]
 * 直接插入排序比冒泡和简单选择排序的性能要好一些  
 */
public class StraightInsertionSort {
	
	public static void straightInsertionSort(int [] numbers){
		
		int temp=0; 
		
		for(int i=1;i<numbers.length;i++){
			int y;
			if(numbers[i-1]>numbers[i]){
				temp = numbers[i];
				for(y=i-1;y>=0 && numbers[y]>temp;y--){
					numbers[y+1]=numbers[y];
				}
				numbers[y+1]=temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int [] numbers = Numbers.NUMBERS;
		long startTime = System.nanoTime();
		straightInsertionSort(numbers);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	}

}
