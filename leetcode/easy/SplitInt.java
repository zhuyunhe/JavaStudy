package easy;

import java.util.ArrayList;
import java.util.List;

public class SplitInt {
	public static List<Integer> splitInt(int n){
		List<Integer> list = new ArrayList<Integer>();
		while(n>0){
			list.add(n%10);
			n /= 10;
		}
		return reverseList(list);
	}
	
	/**
	 * µ¹ÖÃÒ»¸ölistµÄË³Ğò
	 * @param list
	 * @return
	 */
	public static List<Integer> reverseList(List<Integer> list){
		int size =list.size();
		int medium = size/2;
		int last = size - 1;
		
		for(int i=0; i<medium; i++){
			int tem = list.get(i);
			list.set(i, list.get(last-i));
			list.set(last-i, tem);
		}
		
		return list;
	}
	
	public static void main(String[] args){
		int a = 1234566;
		List<Integer> list = splitInt(a);
		System.out.println(list);
	}
}
