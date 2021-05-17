package P00_OldClass;

import P02_Sort.Code02_BubbleSort;

public class Code06_Sorts {
	
	static void printArray(int[] arr) {
		for(int a:arr) {
			System.out.print(a + "\t");
		}
		System.out.println();
	}
	
	static void exchange(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	static void bubbleSort(int[] arr) {
		//先想边界条件
		if(arr==null || arr.length<2) {
			return;
		}
		
		//0~n-1、0~n-2、0~n-3、0~end
		for(int end=arr.length-1;end>=0;end--) {
			//0~end判断是否交换
			for(int first = 0;first < end;first++) {
				if(arr[first]>arr[first+1]) {
					exchange(arr,first,first+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {22,3,4,11,4,35,555,40,33};
		printArray(arr);

		new Code02_BubbleSort().bubbleSort(arr);
		//selectSort(arr);//选择排序-直接
		//bubbleSort(arr);//冒泡排序
		//insertSort(arr);//插入排序-直接
		
		printArray(arr);
	}

}
