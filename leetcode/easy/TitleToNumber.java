package easy;

public class TitleToNumber {
	/**
	 * 26进制转换为10进制
	 * @param s
	 * @return
	 */
	public static int titleToNumber(String s){
		char[] arr = s.toCharArray();
		
		int result = 0;
		
		for(int i=0; i<arr.length; i++){
			char c = arr[i];
			if(c>='A' && c<='Z'){
			int k = c-'A'+1;
			result += k*Math.pow(26, arr.length-1-i);
			} else{
				return 0;
			}
		}
		
		System.out.println(result);
		return result;
	}
	
	/**
	 * 改进版本
	 * @param s
	 * @return
	 */
	public static int titleToNumber_1(String s){
		char[] arr = s.toCharArray();
		int result = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i]>='A' && arr[i]<='Z'){
				
			result = result*26 + (arr[i]-'A'+1);
			} else{
				return 0;
			}
		}
		System.out.println(result);
		return result;
		
	}
	
	
	public static void main(String[] args){
		titleToNumber("AB");
		titleToNumber_1("AB");
	}
}
