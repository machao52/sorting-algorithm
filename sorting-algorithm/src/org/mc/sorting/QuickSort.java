package org.mc.sorting;

import java.util.Arrays;

/**
 * @author machao
 * Created in 2016/12/29
 * 快速排序: 通过一趟排序将待排记录分割成独立的两部分,其中一部分记录的关键字均比另一部分的关键字小,
 *         则可分别对这两部分记录继续进行排序,以达到整个序列有序的目的.
 * 最好情况时间复杂度为O[nlogn],最坏情况为O[n^2],空间复杂度为O[logn];
 */
public class QuickSort {
	
	
	/**
	 * 快速排序标准版
	 * @param numbers
	 * @param low
	 * @param high
	 */
	public static void Qsort(int [] numbers,int low,int high){
		
		//枢轴(左边的值比它小,右边的值比它大的位置.)
		int pivot;
		if(low<high){
			pivot = partition(numbers,low,high);
			Qsort(numbers,low,pivot-1);
			Qsort(numbers,pivot+1,high);
		}
	}
	
	/**
	 * 分割数组
	 * @param numbers
	 * @param low
	 * @param high
	 * @return
	 */
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
	 * 交换位置
	 */
	public static void swap(int [] numbers,int i,int y){
		int temp=0;
		temp=numbers[i];
		numbers[i]=numbers[y];
		numbers[y]=temp;
	}
	
	/**
	 * 快速排序优化版
	 * @param numbers
	 * @param low
	 * @param high
	 */
	public static void QsortOptimize(int [] numbers,int low,int high){
		
		int pivot;
		if(low<high){
			pivot = partitionOptimize(numbers,low,high);
			QsortOptimize(numbers,low,pivot-1);
			QsortOptimize(numbers,pivot+1,high);
		}
	}
	/**
	 * 分割数组
	 * @param numbers
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partitionOptimize(int [] numbers,int low,int high){
		
		medianOfThree(numbers,low,high);
		int pivotValue = numbers[low];
		while(low<high){
			while(low<high && numbers[high]>=pivotValue){
				high--;
			}
			numbers[low] = numbers[high];
			while(low<high && numbers[low]<=pivotValue){
				low++;
			}
			numbers[high] = numbers[low];
		}
		
		numbers[low] = pivotValue;
		
		return low;
	}
	
	/**
	 * 三数取中法:即取三个关键字先进性排序,将中间数作为枢轴,一般是取左端、右端和中间三个数，
	 * 也可以随机选取。这样至少这个中间数一定不会是最小或者最大的数，从概率上来说，取三个数
	 * 均为最小或者最大数的可能性是微乎其微的，因此中间数位于较为中间的值的可能性就大大提高了。
	 * 随机选取三个数和从左中右端取三个数是一回事，而且随机数生成器本身还会带来时间上的开销，
	 * 因此随机生成不予考虑。（如果想要更接近中间值，可以用“九数取中”。从数组中分三次取样，
	 * 每次取三个数，三个样品各取出中数，然后从这三个中数当中再取出一个中数作为枢轴。）
	 * @param numbers
	 */
	public static void medianOfThree(int [] numbers,int low,int high){
		int m = low+(high-low)/2;
		if(numbers[low]>numbers[high]){
			swap(numbers,low,high);
		}
		if(numbers[m]>numbers[high]){
			swap(numbers,m,high);
		}
		if(numbers[m]>numbers[0]){
			swap(numbers,m,low);
		}
	}
	
	/**
	 * 快速排序终极版,效率最高
	 * @param numbers
	 * @param low
	 * @param high
	 */
	public static void quickSortFinal(int [] numbers,int low,int high){
		int pivot;
		while(low<high){
			pivot=partitionOptimize(numbers, low, high);
			quickSortFinal(numbers,low,pivot-1);
			low=pivot+1;
		}
	}
	
	
	
	public static void main(String[] args) {
		int [] numbers = Numbers.NUMBERS;
		long startTime = System.nanoTime();
		//Qsort(numbers,0,numbers.length-1);
		 QsortOptimize(numbers, 0, numbers.length-1);
		//quickSortFinal(numbers, 0, numbers.length-1);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	   
	}

}
