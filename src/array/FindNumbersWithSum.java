package array;

public class FindNumbersWithSum {
	/**
	 * ����һ����������������һ������sum���������в�����������ʹ���ǵĺ�������sum
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
