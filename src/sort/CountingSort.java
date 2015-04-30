package sort;

public class CountingSort {
	/**
	 * 计数排序，剑指offer第65页
	 * @param a
	 * @param length
	 */
	public static void countingSort(int[] a,int length,int range){
		if(a==null || length<=0){
			return;
		}
		//要排序的数的最大值
		int k = 4;
		
		int[] c = new int[k];
		
		for(int i=0; i<length; i++){
			int temp = a[i];
			
			c[temp-1]++;
		}
		
		int index = 0;
		for(int i=0; i<k; i++){
			for(int j=0; j<c[i];j++){
				//i+1是因为数组下标从0开始，和实际数的大小差了1，慢慢理解
				a[index] = i+1;
				index++;
			}
		}
	}
	
	/**
	 * 计数排序，算法导论里的写法
	 * @param a
	 * @param length
	 */
	public static void countingSort2(int[] a,int length,int range){
		if(a==null || length<=0){
			return;
		}
		//要排序的数的最大值
		int k = range;
		
		int[] c = new int[k];
		
		for(int i=0; i<length; i++){
			int temp = a[i];
			
			c[temp-1]++;
		}
		
		//更新数组c
		for(int i=0; i<k-1; i++){
			c[i+1] += c[i];
		}
		
		int index = 0;
		int[] temp = new int[length];
		for(int i=a.length-1; i>=0; i--){
			int value = a[i];
			int position = c[value-1] - 1;
			
			temp[position] = value;
			c[value-1]--;
		}
		
		for(int i=0; i<a.length; i++){
			a[i] = temp[i];
		}
	}
	//找到数组中最大数
	public static int findMax(int[] a){
		int maxIndex = 0;
		for(int i=0; i<a.length; i++){
			if(a[i]>a[maxIndex]){
				maxIndex = i;
			}
		}
		
		return a[maxIndex];
	}
	
	
	public static void main(String[] args){
		int[] a = {1,3,4,4,3};
		countingSort2(a, a.length,findMax(a));
		
		for(int i : a){
			System.out.println(i);
		}
	}
}
