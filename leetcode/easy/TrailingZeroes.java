package easy;

public class TrailingZeroes {
	/**
	 * ����һ������n������n!��n�Ľ׳ˣ������еĺ�׺0�ĸ���
	 * Ч�ʵ͵ķ���,�Ȱѽ׳˼��������Ȼ���ڶ�10ȡ��
	 * @param n
	 * @return
	 */
	public static int trailingZeroes(int n){
		int f = f(n);
		
		System.out.println(f);
		
		int zeroNum = 0;
		while(f>=0 && f%10 == 0){
			zeroNum++;
			f /=10;
		}
		System.out.println(zeroNum);
		return zeroNum;
	}
	
	public static int trailingZeroes_1(int n){
		int result = 0;
		int x = 5;
		while(n >= x){
			result += n/x;
			x *= 5;
		}
		System.out.println(result);
		return result;
		
	}
	
	/**
	 * ��1~n����ȡ��ÿ�������������е�5
	 * @param n
	 * @return
	 */
	public static int trailingZeroes_2(int n){
		int result = 0;
		for(int i=1; i<=n; i++){
			int temp = i;
			while(temp%5 == 0){
				result++;
				temp /= 5;
			}
		}
		System.out.println(result);
		return result;
		
	}
	
	/**
	 * �ҳ���Щ�ܱ�5��������
	 * leetcode��accept
	 * @param n
	 * @return
	 */
	public static int trailingZeroes_3(int n){
        int result = 0;
		while(n>0){
			result += n/5;
			n /= 5;
		}
		System.out.println(result);
		return result;
	}
	
	/**
	 * ��n�Ľ׳˺���
	 * @param n
	 * @return
	 */
	public static int f(int n){
		int result;
		if(n<=1){
			return 1;
		} else{
			result = f(n-1)*n;
			return result;
		}
		
	}
	
	public static void main(String[] args){
		//trailingZeroes(25);
		trailingZeroes_3(25);
	}
}
