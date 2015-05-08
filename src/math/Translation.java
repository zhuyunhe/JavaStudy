package math;

public class Translation {
	/**
	 * 判断一个字符串是不是回文
	 * 使用循环，头尾对应位置依次比较
	 * @param s
	 * @return
	 */
	public static boolean isTranslation(String s){
		int len = s.length();
		if(len>0){
			char[] arr = s.toCharArray();
			for(int i=0; i<len/2; i++){
				if(arr[i] != arr[len-1-i]){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 使用递归思想
	 * 每次检查后去掉两端的两个字符，层层缩小要检查的字符串的范围
	 * 当要检查的字符串的范围的宽度为1或0时，递归退出
	 * @param s
	 * @param low
	 * @param high
	 * @param len
	 * @return
	 */
	public static boolean isTranslationRec(String s,int low, int high, int len){
		if(len == 0 || len==1){
			return true;
		}
		
		char[] arr = s.toCharArray();
		//不符合回文条件，返回false
		if(arr[low] != arr[high]){
			return false;
		}
		
		return isTranslationRec(s, low+1, high-1, len-2);
		
	}
	
	public static void main(String[] args){
		String s = "aaabaaa";
		
		//调用非递归判断
		if(isTranslation(s)){
			System.out.println("s是回文");
		} else{
			System.out.println("nonono");
		}
		
		//调用递归判断
		if(isTranslationRec(s,0,s.length()-1,s.length())){
			System.out.println("s是回文");
		} else{
			System.out.println("nonono");
		}
	}
}
