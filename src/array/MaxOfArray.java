package array;

import java.util.Arrays;

class MString implements Comparable<MString>{
	private String src;
	public MString(String _src){
		this.src = _src;
	}
	@Override
	public int compareTo(MString s) {
		String s1 = this.src+s.src;
		String s2 = s.src+this.src;
		
		if(s1.compareTo(s2)==0){
			return 0;
		} else if(s1.compareTo(s2)>0){
			return 1;
		} else{
			return -1;
		}
	}
	
	 @Override  
	 public String toString() {  
		 return this.src;
	 }
}
/**
 * Ω£÷∏offer33Ã‚
 * @author zhu
 *
 */
public class MaxOfArray {
	public static String findMaxOfArray(int[] a){
		if(a==null){
			return null;
		}
		
		MString[] ms = new MString[a.length];
		
		for(int i=0; i<a.length; i++){
			ms[i] = new MString(a[i]+"");
		}
		
		Arrays.sort(ms);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<a.length; i++){
			sb.append(ms[i].toString());
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		int[] a = {22,1,33,44,0};
		System.out.println(findMaxOfArray(a));
	}
}
