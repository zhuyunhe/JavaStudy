package easy;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
        
        int more;
        int pos = digits.length - 1;
        
        do{
        	int tem = digits[pos] + 1;
        	if(tem >= 10){
        		digits[pos] = tem - 10;
        		more = 1;
        	} else{
        		digits[pos] = tem;
        		more = 0;
        	}
        	pos--;
        } while(pos>=0 && more==1);
        
        //如果原来的数组存不下了
        if(more == 1){
        	int[] result = new int[digits.length+1];
        	result[0] = 1;
        	//数组拷贝
        	System.arraycopy(digits, 0, result, 1, digits.length);
        	return result;
        } else{
        	return digits;
        }
        
    }
	
	public static void main(String[] args){
		int[] a = {9,9,9,9};
		int[] result = plusOne(a);
	}
}
