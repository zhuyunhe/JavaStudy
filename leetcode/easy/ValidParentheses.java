package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ValidParentheses {
	/**
	 * 栈的最简单应用，平衡符合
	 * @param s
	 * @return
	 */
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
        			//在这就可以直接return
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
	
	public static boolean isValid_1(String s){
		boolean found = true;
		LinkedList<Character> a = new LinkedList<Character>();
        Map<Character,Character> hm = new HashMap<Character, Character>();
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');
        
        for(int i=0; i<s.length(); i++){
        	char c = s.charAt(i);
        	if(c=='(' || c=='{' ||c=='['){
        		a.add(c);
        	} else if(c==')' || c=='}' ||c==']'){
        		if(a.isEmpty() || a.removeLast()!=hm.get(c)){
        			return false;
        		}
        	}
        }
        return a.isEmpty();

	}
	
	public static void main(String[] args){
		String s = "{[]}";
		if(isValid_1(s)){
			System.out.println("ok");
		}
	}
}
