package sort;

/**
 * 选择排序和插入排序类似，都将数据分为有序区和无序区，所不同的是插入排序是将无序区的第一个元素直接
 * 插入到有序区形成一个更大的有序区，而直接选择排序是从无序区选一个最小的直接放到有序区的最后。
 * 它是一种不稳定的排序
 * @author zhu
 *
 */
public class SelectSort {
	public static void main(String[] args){
		int[] a = {0,3,2,1};
    	selectSort(a,a.length);
    	for(int n : a){
    		System.out.println(n);
    	}
	}
	
	public static void selectSort(int[] a,int n){
		int minIndex;
		int temp;
		//从无序区中选一个最小的元素放到有序区的最后，初始时整个数组都是无序区，选一个最小的放到第一位
		for(int i=0; i<n; i++){
			minIndex = i;
			//找出最小元素的下标
			for(int j=i+1; j<n; j++){
				//得到最小元素的下标
				if(a[j] < a[minIndex]){
					minIndex = j;
				}
			}
			//交换位置，把无序区中选出的最小元素放到有序区的最后
			temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}
}
