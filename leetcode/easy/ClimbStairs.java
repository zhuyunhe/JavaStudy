package easy;

public class ClimbStairs {
	/**
	 * 非递归求斐波那契序列的第n项
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
 