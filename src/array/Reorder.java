package array;

public class Reorder {
	/**
	 * 调整数组顺序使奇数位于偶数前面
	 * 两个指针，一个位于数组头开始，向后移动直到它指向偶数
	 * 一个位于数组尾，向前移动直到它指向奇数
	 * 交换位置
	 * @param a
	 */
	public static void reorder(int[] a){
		if(a == null){
			return;
		}
		
		int begin = 0;
		int end = a.length-1;
		
		while(begin<end){
			//begin位置上如果是奇数则begin++
			while(begin<end && !isEven(a[begin])){
				begin++;
			}

			//end位置上如果是偶数则end--
			while(begin<end && isEven(a[end])){
				end--;
			}
			
			if(begin<end){
				swap(a, begin, end);
			}
		}
	}
	
	/**
	 * 交换数组中两个位置上元素的值
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * 判断一个数是否为偶数
	 * @param n
	 * @return
	 */
	public static boolean isEven(int n){
		return (n&0x01)==0;
	}
	
	public static void main(String[] args){
		int[] a = {2,3,4,1,6,7,8,3};
		reorder(a);
		for(int k :a){
			System.out.println(k);
		}
	}
}
