package easy;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
	/**
	 * 栈的最简单应用，平衡符合
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		List<Character> arr = new ArrayList<Character>();
		boolean valid = false;
		int top = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
				arr.add(s.charAt(i));
				top++;
			} else if(s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']'){
				if(top == 0){
					valid = false;
					break;
				} else{
					arr.remove(top);
				}
			}
		}
		if(arr.size() == 0){
			valid = true;
		}
		return valid;   
    }
}
