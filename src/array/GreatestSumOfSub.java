package array;

public class GreatestSumOfSub {
	public static void main(String[] args){
		int[] a = {1,2,3,-55,10,12,-20,23};
		System.out.println(findGreatestSum(a));
	}
	
	public static int findGreatestSum(int[] a){
		if(a==null){
			return 0;
		}
		
		int curSum = 0;
		int greatestSum = Integer.MIN_VALUE;
		
		for(int i=0; i<a.length; i++){
			if(curSum <= 0){
				curSum = a[i];
			} else{
				curSum += a[i];
			}
			
			if(curSum>greatestSum){
				greatestSum = curSum;
			}
		}
		
		return greatestSum;
	}
}
