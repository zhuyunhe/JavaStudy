package easy;

public class NumberToTitle {
	public static void main(String[] args){
		String result = numberToTitle(28);
		System.out.println(result);
	}
	
	/**
	 * 十进制数转换为26进制
	 * @param n
	 * @return
	 */
	public static String numberToTitle(int n){
		String result = "";
		if(n < 1){
			return "";
		} else{
			while(n>0){
				n--;
				char c = (char) (n%26 + 'A');
				result += c;
				n /= 26;
			}
			//上面步骤完成后，顺序是返的，要倒置一下字符串
			return reverseString(result);
		}
	}
	
	/**
     * 倒置字符串
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
