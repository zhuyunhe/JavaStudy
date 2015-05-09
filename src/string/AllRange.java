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
		if(begin == len){
			System.out.println(charToString(c));
		} else{
			//第i个数分别与它后面的数交换得到新的全排列
			for(int i=begin; i<=len; i++){
				swap(c,begin,i);
				permutation(c,begin+1,len);
				swap(c,begin,i);
			}
		}
		
	}
	
	public static void main(String[] args){
		permutation("123");
	}
}
