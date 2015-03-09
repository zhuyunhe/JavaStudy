package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MajorityElement {
	public static int findMajEle(int[] a){
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		
		//根据数组创建一个频度表
		for(int i=0; i<a.length; i++){
			Integer fre = m.get(a[i]);
			//++要前置，或写成fre+1
			m.put(a[i], (fre==null)?1:++fre);
		}
		
		System.out.println(m);

		Set set = m.entrySet();
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			Map.Entry<Integer,Integer> myEntry = (Map.Entry<Integer, Integer>) ite.next();
			if(myEntry.getValue() > a.length/2){
				return myEntry.getKey();
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args){
		int[] a = {2,2,2,1,1,1};
		int result = findMajEle(a);
		System.out.println(result);
	}
}
