package maxSubSum;

public class MaxSubSum {
	
	/**
	 * 枚举出所有子序列
	 * 时间复杂度为O(N^3)
	 * @param array
	 * @return
	 */
	public static int maxSubSum_1(int[] array){
		int maxSum = 0;
		for(int i=0; i<array.length; i++){
			for(int j=i; j<array.length; j++){
				int tempSum = 0;
				for(int k=i; k<=j; k++){
					tempSum += array[k];
				}
				
				if(tempSum > maxSum){
					maxSum = tempSum;
					}
			}
		}
		
		return maxSum;
	}
	
	public static int maxSubSum_2(int[] array){
		int maxSum = 0;
		for(int i=0; i<array.length; i++){
			int tempSum = 0;
			for(int j=i; j<array.length; j++){
				tempSum += array[j];
				if(tempSum > maxSum){
					maxSum = tempSum;
				}
			}
			
		}
		return maxSum;
		
	}
	
	/**
	 * 分治策略，分为左右两部分
	 * 结果分三种情形：最大子序列在左边，最大子序列在右边，或者横跨左右
	 * 时间复杂度：O(N*LogN)
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int maxSubSum_3(int[] array,int left,int right){
		
		//分解到单个整数，不可继续分解
		if(left == right){
			if(array[left] >0){
				return array[left];
			} else{
				return 0;
			}
		}
		
		int center = (left+right)/2;
		int maxLeftSum = maxSubSum_3(array, left, center);
		int maxRightSum = maxSubSum_3(array, center+1, right);
		
		//计算出包含center的最大值，然后判断情形1，2，3
		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;
		for(int i=center; i>=left;i--){
			leftBorderSum += array[i];
			
			if(leftBorderSum > maxLeftBorderSum){
				maxLeftBorderSum = leftBorderSum;
			}
		}
		
		int maxRightBorderSum = 0;
		int rightBorderSum = 0;
		for(int i=center+1; i<=right;i++){
			rightBorderSum += array[i];
			
			if(rightBorderSum > maxRightBorderSum){
				maxRightBorderSum = rightBorderSum;
			}
		}
		
		int borderSum = maxLeftBorderSum + maxRightBorderSum;
		
		int maxSum = max3(maxLeftSum,maxRightSum,borderSum);
		return maxSum;
	}
	
	public static int max3(int a, int b, int c){
		if(a>b){
			b=a;
		}
		if(b>c){
			c=b;
		}
		
		return c;
	}
	
	/**
	 * 一个正数如果加上一个负数那么得到的结果一定比原来小，
	 * 所以我们可以这样来分析每次加上最新的元素，先与maxSum进行比较，如果大于则把它赋值给maxSum，否则如果结果小于0，那么就从新开始
	 * 时间复杂度：O(N)
	 * @param array
	 * @return
	 */
	public static int maxSubSum_4(int[] array){
		int maxSum = 0;
		int tempSum = 0;
		
		for(int i=0; i<array.length; i++){
			tempSum += array[i];
			
			if(tempSum > maxSum){
				maxSum = tempSum;
			} else if(tempSum < 0){
				tempSum = 0;
			}
		}
		
		return maxSum;
	} 
	
	public static void main(String[] args){
		int[] array = {-2,11,-4,13,-5,-2};
		
		int maxSum_1 = maxSubSum_1(array);
		
		System.out.println("解法一："+maxSum_1);
		
		int maxSum_2 = maxSubSum_2(array);
		
		System.out.println("解法二："+maxSum_2);

		int maxSum_3 = maxSubSum_3(array, 0, 5);
		
		System.out.println("解法三："+maxSum_3);

		int maxSum_4 = maxSubSum_4(array);
		
		System.out.println("解法四："+maxSum_4);
	}
}
