package array;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args){
		int[] a = {1,2,3,4};
		
		int[] b1 = copy_1(a);
		int[] b2 = copy_2(a);
		int[] b3 = copy_3(a);
		int[] b4 = copy_4(a);
	}
	
	public static int[] copy_1(int[] a){
		int length = a.length;
		int[] b= new int[length];
		for(int i=0; i<length; i++){
			b[i] = a[i];
		}
		return b;
	}
	
	public static int[] copy_2(int[] a){
		int[] b= a;
		return b;
	}
	
	public static int[] copy_3(int[] a){
		int[] b= Arrays.copyOf(a, a.length);
		return b;
	}

	public static int[] copy_4(int[] a){
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		return b;
	}
}
