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
	public static  boolean validPalindrome(int n){
		if(n<0){
			return false;
		}
		int base = 1;
		
		//计算出一个base基数用于取得最高位
		while(n/base >= 10){
			base *= 10;
		}
		
		while(n>0){
			//取得最高位
			int left = n/base;
			
			//取得最低位
			int right = n%10;
			
			//判断
			if(left != right){
				return false;
			}
			
			//把比较过的两位删掉
			n -= left*base;
			n /= 10;
			
			//因为每次消去了两位，所以base也要减少两位
			base /= 100;
			
		}
		return true;
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
		
		int n =12321;
		if(validPalindrome(n)){
			System.out.println("okint");
		} else{
			System.out.println("noint");
		}
		
	}
}
