package org.mc.sorting;

import java.util.Arrays;

/**
 * @author machao
 * Created in 2016/12/29
 * 冒泡排序: 两两比较相邻记录的关键字,如果反序则交换,直到没有反序的记录为止.
 * 时间复杂度: 理想的情况为O[n],总的时间复杂度为O[n^2]
 * <li>比较相邻的元素。如果第一个比第二个大，就交换他们两个。</li>  
 * <li>对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。</li>  
 * <li>针对所有的元素重复以上的步骤，除了最后一个。</li>  
 * <li>持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。</li>  
 */
public class BubbleSort {
	
	/**
	 * 冒泡排序初级版,效率低
	 * @param numbers
	 */
	public static void bubbleSortPrimary(int [] numbers){
		int size=numbers.length;
		for(int i=0;i<size-1;i++){
			for(int y=i+1;y<size;y++){
				if(numbers[i]>numbers[y]){
					swap(numbers,i,y);
				}
			}
		}
	}
	
	/**
	 * 冒泡排序标准版,效率高
	 * @param numbers
	 */
	public static void bubbleSortNormal(int [] numbers){
		int size=numbers.length;
		for(int i=0;i<size-1;i++){
			for(int y=1;y<size;y++){
				if(numbers[y-1]>numbers[y]){
					swap(numbers,y-1,y);
				}
			}
		}
	}
	
	/**
	 * 冒泡排序优化版,效率高
	 * @param numbers
	 */
	public static void bubbleSortOptimize(int [] numbers){
		int size=numbers.length;
		boolean flag=true;
		for(int i=0;i<size-1 && flag;i++){
			flag=false;
			for(int y=1;y<size;y++){
				if(numbers[y-1]>numbers[y]){
					swap(numbers,y-1,y);
					flag=true;
				}
			}
		}
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
		long startTime=System.nanoTime();
		//bubbleSortPrimary(numbers);
		//bubbleSortNormal(numbers);
		bubbleSortOptimize(numbers);
		long endTime=System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	}

}
