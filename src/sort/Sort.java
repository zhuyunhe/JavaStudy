package sort;

public class Sort {
	
	/**
	 * ��������
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
	 * ϣ������,�ֳ���С��������
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
	 * ��ѡ������
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
	
	//�������heap���е��㷨
	
	/**
	 * �鲢����
	 * �鲢�����ʱ�临�Ӷ�Ҳ��O(N*logN),���鲢����ÿ�ζ������ڵ������н��в���������Ч��Ҳ����
	 * �鲢������Java����з���������ʹ�õķ���,��ʹ�������ٵıȽϴ���
	 * @param a
	 * @param tmpArray
	 * @param left
	 * @param right
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] a,T[] tmpArray,int left,int right){
		
		if(left < right){
			int center = (left+right)/2;
			
			//�ȵݹ�ֽ�����
			mergeSort(a,tmpArray,left,center); //�������
			mergeSort(a,tmpArray,center+1,right); //�ұ�����
			
			//��ʼ�ƶ�������Ԫ�ص�λ�ã���ʼ�鲢
			merge(a, tmpArray, left, center+1, right);
		}
		
	}
	
	/**
	 * �鲢����
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
		
		//�����������ʣ���Ԫ�ؿ�������ʱ������
		while(leftPos <= leftEnd){
			tmpArray[tmpPos++] = a[leftPos++];
		}
		
		//���Ұ�������ʣ���Ԫ�ؿ�������ʱ������
		while(rightPos <= rightEnd){
			tmpArray[tmpPos++] = a[rightPos++];
		}
		
		//����ʱ�����е�Ԫ�ؿ�����ԭ������ȥ
		//�����״�
		for(int i=0; i<numElements; i++,rightEnd--){
			a[rightEnd] = tmpArray[rightEnd];
		}
	}
	
	public final static int CUTOFF = 1;
	/**
	 * ������ֵ�ָ
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
		
		//��pivot����right-1λ����
		swapReference(a, center, right-1);
		
		//����pivot
		return a[right-1];
		
	}
	/**
	 * ��������������λ����Ԫ�ص�ֵ
	 * @param a Ŀ������
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
			
			//��pivot�iλ����
			if(i-j == 1) //һ����������
			swapReference(a, i, right-1);
			
			quickSort(a, left, i-1);
			quickSort(a, i+1, right);
		}
	}
	
	public static <T extends Comparable<? super T>> void quickSort(T[] a){
		quickSort(a, 0, a.length-1);
	}
	
	/**
	 * ð������
	 * ʱ�临�Ӷ�ΪO(N^2)
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
	 * �Ľ���ð������,����һ����־λ���ڲ�ѭ�������һ��û�з�����������˵�������Ѿ����
	 * ʱ�临�Ӷ�ΪO(N)
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
	 * �Ľ���ð������,����һ����־λ���ڲ�ѭ�������һ��û�з���������flagΪtrue��˵�������Ѿ����
	 * ʱ�临�Ӷ�ΪO(N)
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
	 * �Ľ���ð������,��¼�����ÿһ��ѭ�������һ��������λ�ã���λ��֮��϶����ź���ģ��´��ڲ�ѭ��ʱֻҪѭ�������λ�þͺ�
	 * ʱ�临�Ӷ�ΪO(N)
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
		//��������
		//insertionSort(arr);
		
		//ϣ������
		//shellSort(arr);
		
		//ѡ ������
		//selectSort(arr);
		
		//�鲢����
		//mergeSort(arr, tmpArray, 0, arr.length-1);
		
		//��������
		//quickSort(arr);
		
		//ð������
		//bubbleSort(arr);
		//improvedBubbleSort(arr);
		improvedBubbleSort_2(arr);
		
		for(int i : arr){
			System.out.print(i+",");
		}
	}
	
	
}
