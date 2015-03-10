package easy;

public class HammingWeight {
	/**
	 * n如果是负数的话这个方法不对噢
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n){
		
		String bin = Integer.toBinaryString(n);
		int result = 0;
		while(n>0){
			if((n&1) == 1){
				result++;
			}
			n >>= 1;
		}
		
		return result;
	}
	
	public static int hammingWeight_1(int n){
		//注意补码，计算机中的数是用补码表示
		String bin = Integer.toBinaryString(n);
		int result = 0;
		int flag = 1;
		while(flag != 0){
			if((n&flag) != 0){
				result++;
			}
			flag <<= 1;
		}
		return result;
	}
	
	/**
	 * 更牛逼的算法
	 * 剑指offer的80页
	 * @param n
	 * @return
	 */
	public static int hammingWeight_2(int n){
		int result = 0;
		while(n != 0){
			result++;
			n = (n-1) & n;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int n = 6;
		System.out.println(hammingWeight_1(n));
		System.out.println(hammingWeight_2(n));
	}
}
