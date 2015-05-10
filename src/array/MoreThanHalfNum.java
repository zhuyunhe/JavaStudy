package array;

/**
 * 剑指offer29，找到数组中出现次数超过一半的数字
 * @author zhu
 *
 */
public class MoreThanHalfNum {
	/**
	 * 把一个数组以index为界分为左右两部分，index左边的数小于index，index右边的数大于index
	 * @param a
	 * @param left
	 * @param right
	 * @return index
	 */
	public static int partition(int[] a, int left, int right){
		if(left > right){
			return 0;
		}
		
		int povit = a[left];
		
		while(left<right){
			while(left<right && a[right]>povit){
				right--;
			}
			
			a[left] = a[right];
			
			while(left<right && a[left]<=povit){
				left++;
			}
			
			a[right] = a[left];
		}
		
		a[left] = povit;
		
		return left;
	}
	
	public static int findMoreThanHalfNum(int[] a){
		int len = a.length;
		int middle = len >> 1;
		int left = 0;
		int right = len-1;
		
		int index = partition(a, left, right);
		
		while(index != middle){
			if(middle < index){
				right = index - 1;
				index = partition(a, left, right);
			} else{
				left = index+1;
				index = partition(a, left, right);
			}
		}
		int result = a[index];
		
		if(!check(a,result)){
			return 0;
		}

		return result;
	}
	
	/**
	 * 检查数组num在数组a中出现的次数是否超过一半
	 * @param a
	 * @param num
	 * @return
	 */
	public static boolean check(int[] a, int num){
		int count = 0;
		for(int i=0; i<a.length; i++){
			if(a[i] == num){
				count++;
			}
		}
		
		boolean result = true;
		if(a.length/2 >= count){
			result = false;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,2,2,2,2,2,6};
		System.out.println(findMoreThanHalfNum(a));
	}
}
