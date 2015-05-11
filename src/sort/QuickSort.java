package sort;

/**
 * ��������
 * �ȴ�������ȡ��һ������Ϊ��׼��
 * ���������������׼�������ȫ���ŵ������ұߣ�С�ڻ����������ȫ���ŵ����
 * Ȼ���ڷֱ�����������ظ��ڶ�����ֱ����������ֻ��һ����
 * @author zhu
 *
 */
public class QuickSort {
	/**
	 * ��������������λ����Ԫ�ص�ֵ
	 * @param a Ŀ������
	 * @param i
	 * @param j
	 */
	public static  void swapReference(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * ����һ�������еĿ���
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void quicksort(int[] a,int left,int right){
		if(left<right){
			
		int povit = a[left];
		
		int low = left;
		
		int high = right;
		
		while(low < high){
			while(low<high && a[high] > povit){
				high--;
			}
			if(low<high){
				swapReference(a, low, high);
			}
			
			while(low<high && a[low] <= povit){
				low++;
			}
			if(low<high){
			swapReference(a, low, high);
			}
			
		}
		
		quicksort(a,left, low-1);
		quicksort(a,low+1, right);
		
		}
	}
	
	/**
	 * ��һ��������indexΪ���Ϊ���������֣�index��ߵ���С��index��index�ұߵ�������index
	 * @param a
	 * @param left
	 * @param right
	 * @return index
	 */
	public static int partition(int[] a, int left, int right){
		int povit = a[left];
		
		int low = left;
		int high = right;
		
		while(low < high){
			while(low<high && a[high]>povit){
				high--;
			}
			if(low < high){
				a[low] = a[high];
			}
			
			//<=�ñ�����
			while(low<high && a[low]<=povit){
				low++;
			}
			if(low<high){
				a[high] = a[low];
			}
		}
		
		a[low] = povit;
		
		return low;
	}
	
	/**
	 * partition������ȡ��ȥ�Ŀ���
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void quicksort2(int[] a,int left,int right){
		if(left > right){
			return;
		}
		
		int index = partition(a, left, right);
		
		quicksort2(a,left,index-1);
		quicksort2(a,index+1,right);
	}
	
	public static void main(String[] args){
		int[] a = {5,4,3,2,1};
		quicksort2(a, 0, a.length-1);
		
		for(int i : a){
			System.out.print(i+",");
		}
	}
}
