package org.mc.sorting;

import java.util.Arrays;

public class Test4 {
	
	/**
<<<<<<< HEAD
	 * 冒泡排序
	 * @param numbers
	 */
	public static void bubbleSort(int [] numbers){
		boolean flag=true;
		for(int i=0;flag && i<numbers.length;i++){
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
		int temp;
		for(int i=0;i<numbers.length;i++){
			temp=i;
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
			int temp=numbers[i];
			int y;
			for(y=i-1;y>=0 && temp<numbers[y];y--){
				numbers[y+1]=numbers[y];
			}
			numbers[y+1]=temp;
=======
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
>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
		}
	}
	
	/**
	 * 快速排序
	 * @param numbers
<<<<<<< HEAD
	 */
	public static void quickSort(int [] numbers,int low,int high){
		int pivot;
	    while(low<high){
			pivot=partation(numbers,low,high);
			quickSort(numbers,low,pivot-1);
			low=pivot+1;
		}
		/*if(low<high){
			pivot=partation(numbers,low,high);
			quickSort(numbers,low,pivot-1);
			quickSort(numbers,pivot+1,high);
		}*/
	}
	
	
	
	public static int partation(int [] numbers,int low,int high){
		middleOfThree(numbers,low,high);
		int pivotValue=numbers[low];
		while(low<high){
			while(low<high && numbers[high]>=pivotValue){
				high--;
			}
			numbers[low]=numbers[high];
			while(low<high && numbers[low]<=pivotValue){
=======
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
>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
				low++;
			}
			numbers[high]=numbers[low];
		}
<<<<<<< HEAD
		numbers[low]=pivotValue;
		return low;
	}
	
	public static void middleOfThree(int [] numbers,int i,int y){
		int mid=(i+y)/2+1;
		if(numbers[mid]>numbers[y]){
			swap(numbers,mid,y);
		}
		if(numbers[i]>numbers[y]){
			swap(numbers,i,y);
		}
		if(numbers[mid]>numbers[i]){
			swap(numbers,mid,i);
		}
	}
	
	
	/**
	 * 希尔排序
	 */
    public static void shellSort(int [] numbers){
    	int increment=numbers.length;
    	do{
    		increment=increment/3+1;
    		for(int i=increment;i<numbers.length;i++){
    			int temp=numbers[i];
    			int y;
    			for(y=i-increment;y>=0 && temp<numbers[y];y-=increment){
    				numbers[y+increment]=numbers[y];
    			}
    			numbers[y+increment]=temp;
    		}
    	}while(increment>1);
    }
	
    /**
     * 堆排序
     * @param numbers
     */
	public static void heapSort(int [] numbers){
		for(int i=numbers.length/2-1;i>=0;i--){
			HSort(numbers,i,numbers.length-1);
		}
		for(int i=numbers.length-1;i>0;i--){
			swap(numbers,0,i);
			HSort(numbers,0,i-1);
		}
	}
	
	public static void HSort(int [] numbers,int s,int n){
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
	 * 归并排序
	 * @param numbers
=======
		numbers[low]=temp;
		return low;
	}
	
	/**
	 * 归并排序
>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
	 */
	public static void mergeSort(int [] numbers){
		int [] TR=new int[numbers.length];
		int k=1;
		while(k<numbers.length){
			mergePass(numbers,TR,k,numbers.length-1);
<<<<<<< HEAD
			k=2*k;
			mergePass(TR,numbers,k,numbers.length-1);
			k=2*k;
=======
			k=k*2;
			mergePass(TR,numbers,k,numbers.length-1);
			k=k*2;
>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
		}
	}
	
	public static void mergePass(int [] SR,int [] TR,int s,int n){
<<<<<<< HEAD
          int i=0;
          while(i<n-2*s+1){
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
=======
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
>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
	}
	
	public static void merge(int [] SR,int [] TR,int s,int m,int n){
		int j,k;
<<<<<<< HEAD
		for(j=m+1,k=s;j<=n && s<=m;k++){
=======
		for(j=m+1,k=s;s<=m && j<=n;k++ ){
>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
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
<<<<<<< HEAD
		
	}
	
	
	
	/**
	 * 交换位置
	 * @param numbers
	 * @param i
	 * @param y
	 */
	public static void swap(int [] numbers,int i,int y){
		int temp=numbers[i];
		numbers[i]=numbers[y];
		numbers[y]=temp;
	}
	
	

	
=======
	}
	
>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
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
<<<<<<< HEAD
=======

>>>>>>> d805868160365fb2a0dfde0065ac7cf285ce936e
}
