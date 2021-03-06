package sort;
/**
 * 归并排序是分治法的典型应用
 * 将数组分成A,B两组，然后再将A,B两组各自再分成两组，依次类推。当分出来的小组只有一个数据时，可以认为
 * 这个小组内已经排好序了，此时再合并相邻的两个小组就可以得到一个新的排好序的小组。
 * 总体思路就是先递归分解数列，然后再合并数列。
 * 改进版：如果低子列表中的最高元素小于高子列表中的最低元素，则忽略合并
 * @author zhu
 *
 */
public class MergeSort {
	public void mergeSort(int[] a, int first, int last, int[] temp){
		if(first<last){
			int mid = (first+last)/2;
			mergeSort(a,first,mid,temp);//左边有序，
			mergeSort(a,mid+1,last,temp);
			
			//把相邻两个有序的数组合并，形成一个新的有序数组
			mergeArray(a,first,mid,last,temp);
		}
	}

	private void mergeArray(int[] a, int first, int mid, int last, int[] temp) {
		int i=first,m=mid;
		int j=mid+1,n=last;
		
		int count = 0;//记录这次合并了几个数
		
		while(i<=m && j<=n){
			if(a[i] <=a[j]){
				temp[count++] = a[i++];
			} else{
				temp[count++] = a[j++];
			}
		}
		
		while(i<=m){
			temp[count++] = a[i++];
		}
		
		while(j<=n){
			temp[count++] = a[j++];
		}
		
		//把临时数组排好序的部分拷贝回原始数组
		for(int k=0; k<count; k++){
			a[first+k] = temp[k];
		}
	}
	
	public static void main(String[] args){
		int[] a = {34,8,64,51,32,21,2,4,6};
		int[] temp = new int[a.length];
		MergeSort ms = new MergeSort();
		
		ms.mergeSort(a, 0, a.length-1, temp);
		
		for(int i : a){
			System.out.print(i+",");
		}
	}
}
