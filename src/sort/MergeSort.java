package sort;

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
