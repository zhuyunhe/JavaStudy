package bit;

public class NumberOf1 {
	/**
	 * 从一个数的地位开始判断这个数的二进制表示中有几个1，这样就不会受标志位影响
	 * @param n
	 * @return
	 */
	public static int numberOf1(int n){
		int count = 0;
		
		int flag = 1;
		
		while(flag>0){
			if((n&flag)>0){
				count++;
			}
			//flag右移一位
			flag = flag << 1;
		}
		
		return count;
	}
	
	/**
	 * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中最右边一个1变成0
	 * @param n
	 * @return
	 */
	public static int numberOf1_2(int n){
		int count = 0;
		
		while(n>0){
			count++;
			n = n&(n-1);
		}
		
		return count;
	}
	
	public static void main(String[] args){
		System.out.println(numberOf1(7));
		System.out.println(numberOf1_2(7));

	}
}
