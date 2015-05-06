package array;

public class ReverseArray {
	public static void reverseArray(int[] arr){
		if(arr == null){
			return;
		}
		
		for(int i=0; i<arr.length/2; i++){
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6};
		reverseArray(a);
		for(int i : a){
			System.out.println(i+"-");
		}
	}
}
