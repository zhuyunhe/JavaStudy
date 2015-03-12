package easy;

import java.util.Arrays;


public class RemoveDupfromSortedArray {
	public static int removeDuplicates(int[] A) {
		if(A.length>0){
			
		int p1 = 0;
		int last = A.length - 1;
		while(p1<last){
			if(A[p1] == A[p1+1]){
				int tem = A[p1+1];
				A[p1+1] = A[last];
				A[last] = tem;
				last--;
			} else{
				p1++;
			}
		}
		
        return A.length-last;
		} else{
			return 0;
		}
    }
	
	public static int removeDuplicates_1(int[] A) {
		int len = A.length;
		if (len == 0)
			return 0;
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (A[i] == A[i - 1]) {
				continue;
			}else{
				A[count] = A[i];
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		int[] A = {1,1};
		System.out.println(removeDuplicates(A));
		
	}
}
