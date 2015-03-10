package easy;

import java.util.Arrays;

public class MergeSortedArray {
	public static void merge(int A[], int m, int B[], int n){
		
		
		while(m>0 && n>0){
			if(A[m-1] > B[n-1]){
				A[m+n-1] = A[m-1];
				m--;
			} else{
				A[m+n-1] = B[n-1];
				n--;
			}
		}
		
		while(m>0){
			A[m+n-1] = A[m-1];
			m--;
		}
		while(n>0){
			A[m+n-1] = B[n-1];
			n--;
		}
		
		
	}
	
	public static void main(String[] args){
		int[] A = new int[10];
		A[0] = 1;
		int[] B = {0,3,4,5};
		
		merge(A, 1, B, B.length);
		
		for(int i : A){
			System.out.print(i);
		}
		
	}
}
