package gcd;

public class Gcd {
	/**
	 * 计算两个数的最大公因数的欧几里得算法
	 * @param m
	 * @param n
	 * @return
	 */
	public static long gcd(long m, long n){
		while(n!=0){
			long rem = m%n;
			m = n;
			n = rem;
		}
		return m;
	}
}
