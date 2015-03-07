package medium;

public class ReverseBits {
	public static void main(String[] args){
		int a = 43261596;
		
		int b = reverseBits(a);
		
		
	}
	
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	int result = 0;
    	
    	for(int i=1; i!=0; i<<=1){
    		
    	}
		return result;
        
    }
    
    /**
     * µ¹ÖÃ×Ö·û´®
     * @param str
     * @return
     */
    private static String reverseString(String str){
    	char[] charArr = str.toCharArray();
    	int size = str.length();
    	int medium = size >> 1;
    	int last = size - 1;
    	for(int i=0; i<medium; i++){
    		char temp = charArr[last -i];
    		charArr[last -i] = charArr[i];
    		charArr[i] = temp;
    	}
		return new String(charArr);
    	
    }
}
