package sort;

public class BubbleSort {
	public static void bubbleSort(int[] a){
		for(int i=0; i<a.length; i++){
			for(int j=1;j<a.length-i;j++){
				if(a[j]<a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort1(int[] a){
		int j,k;
		k=a.length;
		boolean flag = true;
		while(flag){
			flag = false;
			for(j=1; j<k; j++){
				if(a[j]<a[j-1]){
					flag = true;
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
			k--;
		}
	}
	
	public static void bubbleSort2(int[] a){
		int j,k,flag;
		flag = a.length;
		
		while(flag > 0){
			k = flag;
			flag = 0;
			for(j=1; j<k; j++){
				if(a[j] < a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
					flag = j;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] a = {4,6,3,1,2};
		//bubbleSort(a);
		//bubbleSort1(a);
		bubbleSort2(a);
	}
}
