package math;

public class Prime {
	public static void main(String[] args){
		//打印0到100内的素数
		for(int i=2; i<=100; i++){
			if(isPrime(i)){
				System.out.println(i);
			}
		}

	}
	
	/**
	 * 判断一个数是否是素数
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n){
		for(int i=2; i<=Math.sqrt(n); i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
}
