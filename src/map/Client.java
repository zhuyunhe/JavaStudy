package map;

import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void main(String[] args){
		Map<String,Integer> m = new HashMap<String,Integer>();
		
		String[] arr = {"I","am","zhu","zhu","I"};
		
		//�����ַ������鴴������Ƶ�ȱ�
		for(String a : arr){
			Integer freq = m.get(a);
			m.put(a, (freq == null)?1:freq+1);
		}
		
		System.out.println(m);
	}
}
