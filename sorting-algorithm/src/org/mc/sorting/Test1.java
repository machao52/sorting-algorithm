package org.mc.sorting;

import java.util.Arrays;

/**
 * 练习
 * @author machao
 *
 */
public class Test1 {

	/**
	 * 冒泡排序
	 * @param numbers
	 */
	public static void bubbleSort(int [] numbers){
		boolean flag=true;
		for(int i=0;i<numbers.length-1 && flag;i++){
			flag=false;
			for(int y=1;y<numbers.length-i;y++){
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
		int temp; //临时变量
		for(int i=0;i<numbers.length-1;i++){
			temp=i;
			for(int y=i+1;y<numbers.length;y++){
				if(numbers[temp]>numbers[y]){
					temp=y; //把比较小的值的索引赋值给temp
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
		int temp; //临时变量
		int y;
		for(int i=0;i<numbers.length-1;i++){
			temp=numbers[i+1];
			for(y=i+1;y>0 && temp<numbers[y-1];y--){
				numbers[y]=numbers[y-1];
			}
			numbers[y]=temp;
		}
	}
	
	/**
	 * 快速排序
	 * @param numbers
	 * @param s
	 * @param e
	 */
	public static void quickSort(int [] numbers,int low,int high){
		if(low<high){
			int pivot=partation(numbers,low,high);
			quickSort(numbers,low,pivot);
			quickSort(numbers,pivot+1,high);
		}
	}
	
	public static int partation(int [] numbers,int low,int high){
		middleOfThree(numbers,low,high);
		int pivotValue=numbers[low]; //中间数
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
		int middle=(low+high)/2;
		if(numbers[low]>numbers[high]){
			swap(numbers,low,high);
		}
		if(numbers[middle]>numbers[high]){
			swap(numbers,middle,high);
		}
		if(numbers[middle]>numbers[low]){
			swap(numbers,middle,low);
		}
	}
	
	/**
	 * 希尔排序
	 * 跳跃式插入
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
			heapAbjust(numbers, i, numbers.length-1);
		}
		for(int i=numbers.length-1;i>0;i--){
			swap(numbers,0,i);
			heapAbjust(numbers,0,i-1);
		}
	}
	
	public static void heapAbjust(int [] numbers,int s,int e){
		int temp=numbers[s];
		for(int y=s*2;y<=e;y*=2){
			if(y<e && numbers[y]<numbers[y+1]){
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
	 * 交换数组中两数的位置
	 * @param numbers
	 * @param i
	 * @param y
	 */
	public static void swap(int [] numbers,int i,int y){
		int temp=0;
		temp=numbers[i];
		numbers[i]=numbers[y];
		numbers[y]=temp;		
	}
	
	/**
	 * 归并排序
	 * @param SR
	 * @param TR1
	 * @param s
	 * @param e
	 */
	public static void mergeSort(int [] SR,int [] TR1,int s,int e){
		int [] TR2=new int[SR.length];
		if(s==e){
			TR1[s]=SR[s];
		}else{
			int m=(s+e)/2;
			mergeSort(SR,TR2,s,m);
			mergeSort(SR,TR2,m+1,e);
			merge(TR2,TR1,s,m,e);
		}
		
	}
	public static void merge(int [] SR,int [] TR,int s,int m,int e){
		int j,k;
		for(j=m+1,k=s;s<=m && j<=e;k++){
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
		if(j<=e){
			for(int c=0;c<=e-j;c++){
				TR[k+c]=SR[j+c];
			}
		}
	}
	
	public static void mergeSort2(int [] numbers){
		int [] TR=new int[numbers.length];
		int k=1;
		while(k<numbers.length-1){
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
	
	
	public static void main(String[] args) {
		int [] numbers=Numbers.NUMBERS4;
		long startTime=System.nanoTime();
		//bubbleSort(numbers);
		//selectSort(numbers);
		//straightInsertionSort(numbers);
		//quickSort(numbers,0,numbers.length-1);
		//shellSort(numbers);
		//heapSort(numbers);
		//mergeSort(numbers,numbers,0,numbers.length-1);
		mergeSort2(numbers);
		long endTime=System.nanoTime();
		System.out.println(Arrays.toString(numbers));
		System.out.println("time: "+(endTime-startTime)+" ns");
	}
}
