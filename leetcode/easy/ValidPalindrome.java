package easy;

import java.util.Stack;

public class ValidPalindrome {
	public static  boolean validPalindrome(String s){
		if(!("".equals(s))){
			char[] chr = s.toUpperCase().toCharArray();
			Stack st = new Stack<>();
			for(char c: chr){
				if(c>='A'&&c<='Z' || c>='0'&&c<='9'){
						st.push(c);
					}
				}
				
				for(char c: chr){
					if(c>='A'&&c<='Z' || c>='0'&&c<='9'){
						
						char tem = (char)st.pop();
						if(tem != c){
							return false;
						}
					}
				}
				return true;
			    } else{
			    	return true;
			    }
	}
	
	public static  boolean validPalindrome_1(String s){
		if(!("".equals(s))){
			char[] chr = s.toUpperCase().toCharArray();
			int i = 0;
			int j = chr.length-1;
			
			while(i<j){
				if(!(isAlpha(chr[i]))){
					++i;
					continue;
				}
				if(!(isAlpha(chr[j]))){
					--j;
					continue;
				}
				if(chr[i]!=chr[j]){
					return false;
				}
				i++;
				j--;
			}
			
		}
		return true;
	}
	
	private static boolean isAlpha(char c){
		if(c>='A'&&c<='Z' || c>='0'&&c<='9'){
			return true;
		}
			return false;
	}
	
	public static void main(String[] args){
		String s = "A man, a plan, a canal: Panama";
		if(validPalindrome_1(s)){
			System.out.println("ok");
		} else{
			System.out.println("no");
		}
	}
}
