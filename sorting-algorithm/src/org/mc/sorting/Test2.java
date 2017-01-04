package org.mc.sorting;

import java.util.Arrays;

public class Test2 {
	
	/**
	 * 冒泡排序
	 * @param numbers
	 */
	public static void bubbleSort(int [] numbers){
		boolean flag=true;
		for(int i=0;flag && i<numbers.length-1;i++){
			flag=false;
			for(int y=numbers.length-1;y>0;y--){
				if(numbers[y-1]>numbers[y]){
					swap(numbers,y-1,y);
					flag=true;
				}
			}
		}
	}
	
	/**
	 * 简单选择排序
	 * @param numbers
	 */
	public static void selectSort(int [] numbers){
		for(int i=0;i<numbers.length-1;i++){
			int temp = i;
			for(int y=i+1;y<numbers.length;y++){
				if(numbers[temp]>numbers[y]){
					temp=y;
				}
			}
			swap(numbers,i,temp);
		}
	}
	
	/**
	 * 直接插入排序
	 * @param numbers
	 */
	public static void straightInsertionSort(int [] numbers){
		for(int i=1;i<numbers.length;i++){
			if(numbers[i-1]>numbers[i]){
				int temp=numbers[i];
				int y;
				for(y=i-1;y>=0 && numbers[y]>temp;y--){
				    numbers[y+1]=numbers[y];
				}
				numbers[y+1]=temp;
			}
		}
	}
	
	/**
	 * 快速排序
	 */
	public static void quickSort(int [] numbers,int low,int high){
		int pivot;
		if(low<high){
			pivot=partation(numbers,low,high);
			quickSort(numbers,low,pivot);
			quickSort(numbers,pivot+1,high);
		}
	}
	
	public static int partation(int [] numbers,int low,int high){
		middleOfThree(numbers,low,high);//三数取中
		int pivotValue=numbers[low];
		while(low<high){
			while(low<high && numbers[high]>=pivotValue){
				high--;
			}
			numbers[low]=numbers[high];
			while(low<high && numbers[low]<=pivotValue){
				low++;
			}
			numbers[high]=numbers[low];
		}
		numbers[low]=pivotValue;
		return low;
	}
	
	public static void middleOfThree(int [] numbers,int low,int high){
		int mid=(low+high)/2;
		if(numbers[low]>numbers[high]){
			swap(numbers,low,high);
		}
		if(numbers[mid]>numbers[high]){
			swap(numbers,mid,high);
		}
		if(numbers[mid]>numbers[low]){
			swap(numbers,mid,low);
		}
	}
	
	/**
	 * 希尔排序
	 * @param numbers
	 */
	public static void shellSort(int [] numbers){
		int increment=numbers.length-1;
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
	public static void heapSort(int [] numbers,int s,int n){
		//构建大顶堆
		for(int i=(s+n)/2-1;i>=0;i--){
			HSort(numbers,i,n);
		}
		for(int i=n;i>0;i--){
			swap(numbers,0,i);
			HSort(numbers,0,i-1);
		}
	}
	
	public static void HSort(int [] numbers,int s,int n){
		int temp=numbers[s];
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
	
	/**
	 * 归并排序
	 * @param numbers
	 * @param array
	 * @param s
	 * @param n
	 */
	public static void mergeSort(int [] numbers){
		int [] TR=new int[numbers.length];
		int k=1;
		while(k<numbers.length){
			mergePass(numbers,TR,k,numbers.length-1);
			k=2*k;
			mergePass(TR,numbers,k,numbers.length-1);
			k=2*k;
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
			for(int j=i;j<=n;j++){
				TR[j]=SR[j];
			}
		}
	}
	public static void merge(int [] SR,int [] TR,int s,int m,int n){
		int j, k;
		for(j=m+1,k=s;s<=m && j<=n;k++){
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
	
	/**
	 * 互换位置
	 * @param numbers
	 * @param i
	 * @param y
	 */
	public static void swap(int [] numbers,int i,int y){
		int temp;
		temp=numbers[i];
		numbers[i]=numbers[y];
		numbers[y]=temp;
	}
	
	public static void main(String[] args) {
		int [] numbers=Numbers.NUMBERS;
		long startTime=System.nanoTime();
		//bubbleSort(numbers);
		//selectSort(numbers);
		//straightInsertionSort(numbers);
		//quickSort(numbers,0,numbers.length-1);
		//shellSort(numbers);
		//heapSort(numbers,0,numbers.length-1);
		mergeSort(numbers);
		long endTime=System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
	}
	
}
