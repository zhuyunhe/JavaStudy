package string;

public class ReverseString {
	//递归反转一个字符串中的每一个字符
	public static String reverseRec(char[] c,int left,int right){
		if(c==null){
			return null;
		}
		
		//递归退出条件
		if(left>=right){
			return new String(c);
		}
		
		char temp = c[left];
		c[left] = c[right];
		c[right] = temp;
		
		return reverseRec(c, left+1, right-1);
	}
	
	//反转每个句子中的每个单词
	public static String reverse(String s){
		char[] arr = s.toCharArray();
		//把句子中所有字符先反转一遍
		reverseRec(arr, 0, arr.length-1);
		
		int begin = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] == ' '){
				//把每个单词的顺序变回来
				reverseRec(arr, begin, i-1);
				
				//更新begin到下一个单词开始的位置
				begin = i+1;
			}
		}
		
		return new String(arr);
	}
	
	public static void main(String[] args){
		String s = "abcd";
		System.out.println(reverseRec(s.toCharArray(), 0, s.length()-1));
		
		String juzi = "i love you";
		System.out.println(reverse(juzi));
	}
}
