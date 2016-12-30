package org.mc.sorting;

import java.util.Arrays;

/**
 * @author machao
 * Created in 2016/12/29
 * 快速排序: 通过一趟排序将待排记录分割成独立的两部分,其中一部分记录的关键字均比另一部分的关键字小,
 *         则可分别对这两部分记录继续进行排序,以达到整个序列有序的目的.
 */
public class QuickSort {
	
	
	public static void Qsort(int [] numbers,int low,int high){
		
		//枢轴(左边的值比它小,右边的值比它大的位置.)
		int pivot;
		if(low<high){
			pivot = partition(numbers,low,high);
			Qsort(numbers,low,pivot-1);
			Qsort(numbers,pivot+1,high);
		}
	}
	
	
	public static int partition(int [] numbers,int low,int high){
		
		int pivotValue=numbers[low];
		int temp=low;
	    while(low<high){
	    	while(low<high && numbers[high]>=pivotValue){
	    		high--;
	    	}
	    	if(numbers[high]<pivotValue){
	    		swap(numbers,temp,high);
	    		temp=high;
	    	}
	    	while(low<high && numbers[low]<=pivotValue){
	    		low++;
	    	}
	    	if(numbers[low]>pivotValue){
	    		swap(numbers,temp,low);
	    		temp=low;
	    	}
	    }
		return low;
	}
	
	/**
	 * 交换顺序
	 */
	public static void swap(int [] numbers,int i,int y){
		int temp=0;
		temp=numbers[i];
		numbers[i]=numbers[y];
		numbers[y]=temp;
	}
	
	public static void main(String[] args) {
		int [] numbers = Numbers.NUMBERS;
		Qsort(numbers,0,numbers.length-1);
		System.out.println(Arrays.toString(numbers));
	}

}
