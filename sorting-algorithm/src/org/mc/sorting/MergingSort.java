package org.mc.sorting;

import java.util.Arrays;

/**
 * 归并排序
 * @author machao
 * Created in 2017/01/01
 * 归并排序就是利用归并的思想实现的排序方法。它的原理是假设
 * 初始序列含有n个记录，则可以看成是n个有序的子序列，每个子
 * 序列的长度为1，然后两两归并，得到[n/2]个长度为2或1的有
 * 序子序列，再两两归并，.....,如此重复，知道得到一个长度
 * 为n的有序序列为止，这种排序方法称为2路归并排序。
 * 时间复杂度为O[nlogn],而且这是归并排序算法中最好、最坏、
 * 平均的时间性能。空间复杂度为O[n+logn]。
 * Merge函数中有if(SR[s]<SR[j])语句，这就说明它需要
 * 两两比较，不存在跳跃，因此归并排序是一种稳定的排序算法。
 * 归并排序是一种比较占用内存，但却效率高且稳定的算法。
 */
public class MergingSort {
	
	
	/**
	 * 归并排序递归版，效率较低
	 * @param SR
	 * @param TR1
	 * @param s
	 * @param n
	 */
	public static void mergingSort(int [] SR,int [] TR1,int s,int n){
		
		int [] TR2=new int[SR.length]; //建一个空数组
		
		if(s==n){
			TR1[s]=SR[s];
		}else{
			int m=(s+n)/2;
			mergingSort(SR,TR2,s,m);
			mergingSort(SR,TR2,m+1,n);
			merge(TR2,TR1,s,m,n);
		}
	}
	
	/**
	 * 归并排序迭代版,效率高(推荐使用)
	 */
	public static void mergeSort(int [] numbers){
		int k=1;
		int [] TR=new int[numbers.length];
		while(k<numbers.length-1){
			mergePass(numbers,TR,k,numbers.length-1);
			k=k*2;
			mergePass(TR,numbers,k,numbers.length-1);
			k=k*2;
		}
	}
	/**
	 * 从最小间隔1开始归并
	 */
	public static void mergePass(int [] SR,int []TR,int k, int n){
		int i=0;
		int j;
		while(i<=n-2*k+1){
			merge(SR,TR,i,i+k-1,i+2*k-1); //两两归并
			i=i+2*k;
		}
		
		if(i<n-k+1){ //归并最后两个序列
			merge(SR,TR,i,i+k-1,n);
		}else{
			for(j=i;j<=n;j++){ //若最后只剩下单个子序列
				TR[j]=SR[j];
			}
		}
	}
	
	public static void merge(int [] SR,int [] TR,int s,int m,int n){
		int j,k,c;
		for(j=m+1,k=s;s<=m && j<=n;k++){
			if(SR[s]<SR[j]){
				TR[k]=SR[s++];
			}else{
				TR[k]=SR[j++];
			}
		}
		
		if(s<=m){
			for(c=0;c<=m-s;c++){
				TR[k+c]=SR[s+c];
			}
		}
		
		if(j<=n){
			for(c=0;c<=n-j;c++){
				TR[k+c]=SR[j+c];
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int [] numbers = Numbers.NUMBERS;
		long startTime = System.nanoTime();
		//mergingSort(numbers, numbers, 0,numbers.length-1);
		//mergeSort(numbers);
		long endTime = System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	   
	}

}
