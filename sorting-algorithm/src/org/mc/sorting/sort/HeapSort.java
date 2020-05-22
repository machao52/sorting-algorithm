package org.mc.sorting.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author machao
 * Created in 2017/01/01
 * 堆排序： 就是利用堆（假设利用大顶堆）进行排序的方法。它的基本
 * 思想是，将待排序的序列构造成一个大顶堆。此时整个序列的最大值
 * 就是堆顶的根节点。将它移走（其实就是将其与堆数组的末尾元素交换，
 * 此时末尾元素就是最大值），然后将剩余的n-1个序列重新构造成一个
 * 堆，这样就会得到n个元素中的次小值。如此反复执行，便能得到一个有序
 * 序列了。
 * 堆排序的时间复杂度为O[nlogn],不稳定的排序方法。
 * 另外，由于初始构建堆所需的比较次数较多，因此，它并不适合待排序序列
 * 个数较少的情况。
 */
public class HeapSort {
	
	public static void heapSort(int [] numbers){
		/**
		 * 构建大顶堆
		 */
		for(int i=(numbers.length-1)/2;i>=0;i--){
			heapAbjust(numbers,i,numbers.length-1);
		}
	
		for(int y=numbers.length-1;y>0;y--){
			swap(numbers,0,y);
			heapAbjust(numbers,0,y-1);
		}
		
	}

	
	public static void heapAbjust(int [] numbers,int s,int m){
		int temp=numbers[s]; //临时变量
		for(int y=s*2;y<=m;y*=2){
			//y<m，说明不是最后一个子节点，才能与后面的节点相比较。
			if(y<m && numbers[y]<numbers[y+1]){
				y++;
			}
			if(temp>=numbers[y]){
				break;
			}
			numbers[s]=numbers[y];
			s=y; //接着遍历它的子节点（如果它的子节点还有子节点的话）
		}
		numbers[s]=temp;
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
		long startTime=System.nanoTime();
		heapSort(numbers);
		long endTime=System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	}
}
