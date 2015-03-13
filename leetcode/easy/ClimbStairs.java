package easy;

public class ClimbStairs {
	/**
	 * �ǵݹ���쳲��������еĵ�n��
	 * @param n
	 * @return
	 */
	public  static int climbStairs(int n) {
		if (n == 0 || n == 1)
		      return 1;

	    int pre = 1;
	    int current = 1;
	    for (int i = 2; i <= n; i++) {
	      int temp = current + pre;
	      pre = current;
	      current = temp;
	    }
	    return current;
    }
	
	public static void main(String[] args){
		System.out.println(climbStairs(3));
	}
}
 