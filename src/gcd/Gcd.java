package gcd;

import java.util.ArrayList;
import java.util.List;

public class Gcd {
	/**
	 * 计算两个数的最大公因数的欧几里得算法
	 * @param m
	 * @param n
	 * @return
	 */
	public static long gcd(long m, long n){
		while(n!=0){
			long rem = m%n;
			m = n;
			n = rem;
		}
		return m;
	}
	
	public static boolean isValid(String s) {
        boolean found = false;
        int top = 0;
        List<Character> a = new ArrayList<Character>();
        for(int i=0; i<s.length(); i++){
        	char c = s.charAt(i);
        	
        	if(c=='(' || c=='{' ||c=='['){
        		a.add(c);
        		top++;
        	} else if(c==')' || c=='}' ||c==']'){

        		if(top == 0 || (a.get(top-1)-c!=-2 && a.get(top-1)-c!=-1)){
        			found = false;
        			return found;
        		} else{
        			a.remove(--top);
        		}
        	}
        }
        if(a.size() == 0){
        	found = true;
        }
		return found;
    }
	
	public static void main(String[] args){
		String s = "])";
		if(isValid(s)){
			System.out.println("ok");
		} else{
			System.out.println("no");
		}
	}
}
