package easy;

public class ReverseInt {
	public static int reverse(int x) {
		int result = 0;
		boolean positive = true;
		if(x<0){
			positive = false;
		}
		
		x = Math.abs(x);
		while(x!=0){
			if (result>(Integer.MAX_VALUE-x%10)/10){ // �ǳ�������ж���Խ������
				return 0; 
			}
			result = result*10 + x%10;
			x /= 10;
		}
		if(!positive){
			result = -result;
		}
		return result;
    }
	
	public static void main(String[] args){
		System.out.println(reverse(-2147483412));
	}
}
