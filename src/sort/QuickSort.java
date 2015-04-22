package sort;

/**
 * 快速排序
 * 先从数列中取出一个数作为基准数
 * 分区，将比这个基准数大的数全部放到它的右边，小于或等于它的数全部放到左边
 * 然后在分别对左右区间重复第二步，直到各个区间只有一个数
 * @author zhu
 *
 */
public class QuickSort {
	/**
	 * 交换数组中两个位置上元素的值
	 * @param a 目标数组
	 * @param i
	 * @param j
	 */
	public static  void swapReference(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void quicksort(int[] a,int left,int right){
		if(left<right){
			
		int povit = a[left];
		
		int low = left;
		
		int high = right;
		
		while(low < high){
			while(low<high && a[high] >= povit){
				high--;
			}
			if(low<high){
				swapReference(a, low, high);
			}
			
			while(low<high && a[low] < povit){
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
	
	public static void main(String[] args){
		int[] a = {5,4,3,7,2,6,0};
		quicksort(a, 0, a.length-1);
		
		for(int i : a){
			System.out.print(i+",");
		}
	}
}
