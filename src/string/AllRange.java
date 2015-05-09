package string;

public class AllRange {
	public static void permutation(String s){
		char[] c = s.toCharArray();
		permutation(c, 0, c.length-1);
	}
	
	public static String charToString(char[] c){
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		return sb.toString();
	}
	public static void swap(char[] c,int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	public static void permutation(char[] c,int begin,int len){
		//递归退出条件，当数组中只有一个元素需要全排列时，直接输出数组即可
		if(begin == len){
			System.out.println(charToString(c));
		} else{
			//第i个数分别与它后面的数交换得到新的全排列
			for(int i=begin; i<=len; i++){
				swap(c,begin,i);	//交换数组第一个元素index和后面的某个元素x
				permutation(c,begin+1,len);		//begin元素的后续元素递归全排列
				swap(c,begin,i);	//将第一步交换了的index元素和x元素还原到原始位置，为下一次循环做准备，下一次循环就要交换index和另一个x了
			}
		}
		
	}
	
	public static void main(String[] args){
		permutation("123");
	}
}
