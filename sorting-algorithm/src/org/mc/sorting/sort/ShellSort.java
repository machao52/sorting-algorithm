package org.mc.sorting.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author machao
 * Created in 2017/01/01
 * 希尔排序： 将相距某个“增量”的记录组成一个子序列，这样才能
 * 保证在子序列内分别进行直接插入排序后得到的结果是基本有序
 * 而不是局部有序。
 * 时间复杂度为O[n^3/2]
 * 希尔排序是不稳定的
 */
public class ShellSort {
	
	public static void shellSort(int [] numbers){
		
		int increment=numbers.length; //增量序列
		int temp; //临时变量
		do{
			increment = increment/3+1;
			int y;
			for(int i=increment;i<numbers.length;i++){
				temp=numbers[i];
				for(y=i-increment;y>=0 && numbers[y]>temp;y-=increment){
					numbers[y+increment]=numbers[y];
				}
				numbers[y+increment]=temp;
			}
		}while(increment>1);
	}
	
	public static void main(String[] args) {
		int [] numbers = Numbers.NUMBERS;
		long startTime = System.nanoTime();
		shellSort(numbers);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	}

}
