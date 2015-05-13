package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class FirstNotRepeatChar {
	public static char firstNotRepeatChar(String s){
		char[] a = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<a.length; i++){
			if(map.get(a[i])!=null){
				int num = map.get(a[i]);
				num++;
				map.put(a[i], num);
			} else{
				map.put(a[i], 1);
			}
		}
		
		for(int i=0; i<a.length; i++){
			if(map.get(a[i]) == 1){
				return a[i];
			}
		}
		
		return a[0];
	}
	
	public static String deleteRepeat(String s){
		char[] a = s.toCharArray();
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i=0; i<a.length; i++){
			set.add(a[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<Character> ite = set.iterator();
		while(ite.hasNext()){
			sb.append(ite.next());
		}
		
		return sb.toString();
	}
	public static void main(String[] args){
		String s = "abcdsabcdef";
		System.out.println(firstNotRepeatChar(s));
		System.out.println(deleteRepeat(s));
	}
}
