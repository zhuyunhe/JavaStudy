package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	boolean isFab(int n){
		if(n==1)
			return true;
		//int[] res=new int[n+2];
		List<Integer> res=new ArrayList<Integer>();
		res.add(1);
		res.add(1);
		
		for(int i=2;i<=n&&res.get(i-1)<=n;i++){
			res.add(res.get(i-1)+res.get(i-2));
			if(res.get(i)==n){
				return true;
			}
		}
		return false;
	}
	void print(String str){
		Set<String> sets=new HashSet<String>();
		int n=str.length();
		String tmp;
		for(int i=0;i<n;i++){
			for(int j=i+1;str.length()>0&&j<=n;j++){
				tmp=str.substring(i,j);
				int m=getCounts(tmp);
				if(isFab(m)&&!sets.contains(tmp)){
					sets.add(tmp);
					System.out.println(tmp);
				}
				
			}
		}
	}
	int getCounts(String str){
		Set<Character> sets=new HashSet<Character>();
		for(int i=0;i<str.length();i++){
			sets.add(str.charAt(i));
		}
		return sets.size();
	}

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		new Main().print(str);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.getLast();

	}

}
