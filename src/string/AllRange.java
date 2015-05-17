package string;

import java.util.HashMap;

public class AllRange {
	public static void permutation(String s){
		char[] c = s.toCharArray();
		permutation(c, 0, c.length-1);
	}
	
	//在字符数组c中，[begin,end)中是否有数字与下标为end的数字相等  
	public static boolean isSwap(char[] c, int begin, int end){
		for(int i=begin; i<end; i++){
			if(c[i] == c[end]){
				return false;
			}
		}
		return true;
	}
	
	//交换char数组中两个不同位置上元素的方法
	public static void swap(char[] c,int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	
	//全排列主函数
	public static void permutation(char[] c,int begin,int len){
		//递归退出条件，当数组中只有一个元素需要全排列时，直接输出数组即可
		if(begin == len){
			System.out.println(new String(c));
		} else{
			//第i个数分别与它后面的数交换得到新的全排列
			for(int i=begin; i<=len; i++){
				//去重，begin只有它后面的非重复的数字交换
				if(isSwap(c, begin, i)){
					swap(c,begin,i);	//交换数组第一个元素index和后面的某个元素x
					permutation(c,begin+1,len);		//begin元素的后续元素递归全排列
					swap(c,begin,i);	//将第一步交换了的index元素和x元素还原到原始位置，为下一次循环做准备，下一次循环就要交换index和另一个x了
				}
			}
		}
	}
	
	public static void main(String[] args){
		permutation("123");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 1);
		map.put(4, 1);
		String s = "1234";
		String s2 = s.intern();
	}
}
