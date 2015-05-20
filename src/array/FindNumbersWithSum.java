package array;

public class FindNumbersWithSum {
	/**
	 * 输入一个递增排序的数组和一个数字sum，在数组中查找两个数，使它们的和正好是sum
	 * @param a
	 * @param sum
	 */
	public static void findNumWithSum(int[] a,int sum){
		if(a==null || a.length<2){
			return;
		}
		
		int low = 0;
		int high = a.length-1;
		
		int cur = 0;
		while(low < high){
			cur = a[low] + a[high];
			if(cur == sum){
				System.out.println(a[low]+"-"+a[high]);
				low++;
				high--;
			} else if(cur < sum){
				low++;
			} else{
				high--;
			}
		}
	}
	
	public static void main(String[] args){
		int[] a = {1,1,1,2,3,4,5,6,7,8,9,10};
		findNumWithSum(a, 6);
	}
}
