package org.mc.sorting;

import java.util.Arrays;

public class Test4 {
	
	/**
	 * 两数交换位置
	 */
	public static void swap(int [] numbers,int i,int y){
		int temp;
		temp=numbers[i];
		numbers[i]=numbers[y];
		numbers[y]=temp;
	}
	
	/**
	 * 希尔排序
	 * @param numbers
	 */
	public static void shellSort(int [] numbers){
		int increment=numbers.length;
		do{
			increment=increment/3+1;
			for(int i=increment;i<numbers.length;i++){
				if(numbers[i-increment]>numbers[i]){
					int temp=numbers[i];
					int y;
					for(y=i-increment;y>=0 && numbers[y]>temp;y-=increment){
						numbers[y+increment]=numbers[y];
					}
					numbers[y+increment]=temp;
				}
			}
		}while(increment>1);
	}
	
	/**
	 * 堆排序
	 * @param numbers
	 */
	public static void heapSort(int [] numbers){
		for(int i=numbers.length/2-1;i>=0;i--){
			Hsort(numbers,i,numbers.length-1);
		}
		for(int i=numbers.length-1;i>0;i--){
			swap(numbers,0,i);
			Hsort(numbers,0,i-1);
		}
	}
	
	public static void Hsort(int [] numbers,int s,int n){
		int temp=numbers[s];
		if(s<n){
			for(int y=2*s;y<=n;y*=2){
				if(y<n && numbers[y]<numbers[y+1]){
					y++;
				}
				if(temp>=numbers[y]){
					break;
				}
				numbers[s]=numbers[y];
				s=y;
			}
			numbers[s]=temp;
		}
	}
	
	/**
	 * 快速排序
	 * @param numbers
	 * @param s
	 * @param n
	 */
	public static void quickSort(int [] numbers,int low,int high){
		int pivot;
		while(low<high){
			pivot=partition(numbers,low,high);
			quickSort(numbers,low,pivot-1);
			low=pivot+1;
		}
	}
	
	public static int  partition(int [] numbers,int low,int high){
		int temp=numbers[low];
		while(low<high){
			while(low<high && numbers[high]>=temp){
				high--;
			}
			numbers[low]=numbers[high];
			while(low<high && numbers[low]<=temp){
				low++;
			}
			numbers[high]=numbers[low];
		}
		numbers[low]=temp;
		return low;
	}
	
	/**
	 * 归并排序
	 */
	public static void mergeSort(int [] numbers){
		int [] TR=new int[numbers.length];
		int k=1;
		while(k<numbers.length){
			mergePass(numbers,TR,k,numbers.length-1);
			k=k*2;
			mergePass(TR,numbers,k,numbers.length-1);
			k=k*2;
		}
	}
	
	public static void mergePass(int [] SR,int [] TR,int s,int n){
		int i=0;
		while(i<=n-2*s+1){
			merge(SR,TR,i,i+s-1,i+2*s-1);
			i=i+2*s;
		}
		if(i<n-s+1){
			merge(SR,TR,i,i+s-1,n);
		}else{
			for(int y=i;y<=n;y++){
				TR[y]=SR[y];
			}
		}
	}
	
	public static void merge(int [] SR,int [] TR,int s,int m,int n){
		int j,k;
		for(j=m+1,k=s;s<=m && j<=n;k++ ){
			if(SR[s]<SR[j]){
				TR[k]=SR[s++];
			}else{
				TR[k]=SR[j++];
			}
		}
		if(s<=m){
			for(int c=0;c<=m-s;c++){
				TR[k+c]=SR[s+c];
			}
		}
		if(j<=n){
			for(int c=0;c<=n-j;c++){
				TR[k+c]=SR[j+c];
			}
		}
	}
	
	public static void main(String[] args) {
		int [] numbers=Numbers.NUMBERS;
		long startTime=System.nanoTime();
		//bubbleSort(numbers);
		//selectSort(numbers);
		//straightInsertionSort(numbers);
		//quickSort(numbers,0,numbers.length-1);
		//shellSort(numbers);
		//heapSort(numbers);
		mergeSort(numbers);
		long endTime=System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
		
	}

}
