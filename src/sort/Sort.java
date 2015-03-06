package sort;

public class Sort {
	
	/**
	 * 插入排序
	 * @param arr
	 */
	public static <T extends Comparable> void insertionSort(T[] arr){
		for(int i=1; i<arr.length; i++){
			T temp = arr[i];
			
			for(int j=i;j>0&&temp.compareTo(arr[j-1])<0;j--){
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
			
		}
	}
	
	/**
	 * 希尔排序,又称缩小增量排序
	 * @param arr
	 */
	public static <T extends Comparable> void shellSort(T[] arr){
		int j;
		for(int gap=arr.length/2; gap>0; gap/=2){
			for(int i=gap; i<arr.length; i++){
				T temp = arr[i];
				for(j=i;j>=gap && temp.compareTo(arr[j-gap])<0;j-=gap){
					arr[j] = arr[j-gap];
				}
				arr[j] = temp;
			}
		}
	}
	
	
	/**
	 * 简单选择排序
	 * @param arr
	 */
	public static <T extends Comparable> void selectSort(T[] arr){
		int position = 0;
		for(int i=0; i<arr.length; i++){
			T temp = arr[i];
			for(int j=i+1; j<arr.length; j++){
				if(temp.compareTo(arr[j])>0){
					temp = arr[j];
					position = j;
				}
				
			}
			
			arr[position] = arr[i];
			arr[i] = temp;
		}
	}
	
	//堆排序见heap包中的算法
	
	/**
	 * 归并排序
	 * 归并排序的时间复杂度也是O(N*logN),但归并排序每次都是相邻的数据中进行操作，所有效率也更好
	 * 归并排序是Java类库中泛型排序所使用的方法,它使用了最少的比较次数
	 * @param a
	 * @param tmpArray
	 * @param left
	 * @param right
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] a,T[] tmpArray,int left,int right){
		
		if(left < right){
			int center = (left+right)/2;
			
			//先递归分解数列
			mergeSort(a,tmpArray,left,center); //左边有序
			mergeSort(a,tmpArray,center+1,right); //右边有序
			
			//开始移动数组中元素的位置，开始归并
			merge(a, tmpArray, left, center+1, right);
		}
		
	}
	
	/**
	 * 归并函数
	 * @param a
	 * @param tmpArray
	 * @param leftPos
	 * @param rightPos
	 * @param rightEnd
	 */
	public static <T extends Comparable<? super T>> void merge(T[] a,T[] tmpArray,int leftPos,int rightPos,int rightEnd){
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(a[leftPos].compareTo(a[rightPos]) <= 0){
				tmpArray[tmpPos++] = a[leftPos++];
			} else{
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		
		//把左半数组中剩余的元素拷贝到临时数组中
		while(leftPos <= leftEnd){
			tmpArray[tmpPos++] = a[leftPos++];
		}
		
		//把右半数组中剩余的元素拷贝到临时数组中
		while(rightPos <= rightEnd){
			tmpArray[tmpPos++] = a[rightPos++];
		}
		
		//把临时数组中的元素拷贝回原数组中去
		//这容易错
		for(int i=0; i<numElements; i++,rightEnd--){
			a[rightEnd] = tmpArray[rightEnd];
		}
	}
	
	public final static int CUTOFF = 1;
	/**
	 * 三数中值分割法
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static <T extends Comparable<? super T>> T median3(T[] a,int left,int right){
		int center = (left+right)/2;
		
		if(a[center].compareTo(a[left])<0){
			swapReference(a, left, center);
		}
		
		if(a[right].compareTo(a[left])<0){
			swapReference(a, right, left);
		}
		
		if(a[center].compareTo(a[right])>0){
			swapReference(a, center, right);
		}
		
		//把pivot放在right-1位置上
		swapReference(a, center, right-1);
		
		//返回pivot
		return a[right-1];
		
	}
	/**
	 * 交换数组中两个位置上元素的值
	 * @param a 目标数组
	 * @param i
	 * @param j
	 */
	public static <T extends Comparable<? super T>> void swapReference(T[] a,int i,int j){
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static <T extends Comparable<? super T>> void quickSort(T[] a,int left,int right){
		if(left+CUTOFF <= right){
			T pivot = median3(a,left,right);
			 
			int i = left;
			int j = right-1;
			
			for(;;){
				while(a[++i].compareTo(pivot)<0){}
				while(a[--j].compareTo(pivot)>0){}
				
				if(i<j){
					swapReference(a, i, j);
				} else{
					break;
				}
			}
			
			//把pivot填到i位置上
			if(i-j == 1) //一种修正方法
			swapReference(a, i, right-1);
			
			quickSort(a, left, i-1);
			quickSort(a, i+1, right);
		}
	}
	
	public static <T extends Comparable<? super T>> void quickSort(T[] a){
		quickSort(a, 0, a.length-1);
	}
	
	/**
	 * 冒泡排序
	 * 时间复杂度为O(N^2)
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(T[] a){
		for(int i=0; i<a.length; i++){
			for(int j=1; j<a.length-i;j++){
				if(a[j-1].compareTo(a[j])>0){
					swapReference(a, j-1, j);
				}
			}
		}
	}
	
	/**
	 * 改进版冒泡排序,设置一个标志位，内层循环如果有一趟没有发生交换，则说明排序已经完成
	 * 时间复杂度为O(N)
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void improvedBubbleSort(T[] a){
		boolean flag = true;
		
		int k = a.length;
		while(flag){
			flag = false;
			for(int j=1; j<k;j++){
				if(a[j-1].compareTo(a[j])>0){
					swapReference(a, j-1, j);
					flag = true;
				}
			}
			k--;
		}
	}

	/**
	 * 改进版冒泡排序,设置一个标志位，内层循环如果有一趟没有发生交换，flag为true，说明排序已经完成
	 * 时间复杂度为O(N)
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void improvedBubbleSort_1(T[] a){
		boolean flag = true;
		
		int k = a.length;
		
		for(int i=0; i<k; i++){
			flag = false;
			for(int j=k-1;j>i;j--){
				if(a[j].compareTo(a[j-1])<0){
					swapReference(a, j, j-1);
					flag = true;
				}
			}
			if(!flag){
				break;
			}
		}
	}
	
	/**
	 * 改进版冒泡排序,记录下外层每一次循环后最后一个交换的位置，该位置之后肯定是排好序的，下次内层循环时只要循环到这个位置就好
	 * 时间复杂度为O(N)
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void improvedBubbleSort_2(T[] a){
		
		int k = a.length;
		int flag = 0;
		flag = k;
		while(flag>0){
			flag = 0;
			for(int j=1; j<k;j++){
				if(a[j-1].compareTo(a[j])>0){
					swapReference(a, j-1, j);
					flag = k;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		Integer[] arr = {34,8,64,51,32,21,2,4,6};
		Integer[] tmpArray = new Integer[arr.length];
		//插入排序
		//insertionSort(arr);
		
		//希尔排序
		//shellSort(arr);
		
		//选 择排序
		//selectSort(arr);
		
		//归并排序
		//mergeSort(arr, tmpArray, 0, arr.length-1);
		
		//快速排序
		//quickSort(arr);
		
		//冒泡排序
		//bubbleSort(arr);
		//improvedBubbleSort(arr);
		improvedBubbleSort_2(arr);
		
		for(int i : arr){
			System.out.print(i+",");
		}
	}
	
	
}
