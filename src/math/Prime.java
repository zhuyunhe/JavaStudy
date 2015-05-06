package math;

public class Prime {
	public static void main(String[] args){
		//��ӡ0��100�ڵ�����
		for(int i=2; i<=100; i++){
			if(isPrime(i)){
				System.out.println(i);
			}
		}

	}
	
	/**
	 * �ж�һ�����Ƿ�������
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
