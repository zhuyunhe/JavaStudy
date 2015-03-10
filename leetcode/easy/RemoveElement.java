package easy;

public class RemoveElement {
	/**
	 * ÓÃË«Ö¸Õë
	 * @param A
	 * @param elem
	 * @return
	 */
	public static int removeElement(int[] A, int elem) {
		int size = A.length;
		int pos = 0;
		int last = A.length-1;
		while(pos<=last){
			if(A[pos] == elem){
				int tem = A[pos];
				A[pos] = A[last];
				A[last] = tem;
				last--;
				size--;
			} else{
				pos++;
			}
		}
		return size;
    }
	
	public static void main(String[] args){
		int[] a = {1};
		
		int length = removeElement(a, 1);
		
		System.out.println(length);
		
		for(int i : a){
			System.out.print(i);
		}
	}
}
