package string;

import java.util.HashMap;

public class AllRange {
	public static void permutation(String s){
		char[] c = s.toCharArray();
		permutation(c, 0, c.length-1);
	}
	
	//���ַ�����c�У�[begin,end)���Ƿ����������±�Ϊend���������  
	public static boolean isSwap(char[] c, int begin, int end){
		for(int i=begin; i<end; i++){
			if(c[i] == c[end]){
				return false;
			}
		}
		return true;
	}
	
	//����char������������ͬλ����Ԫ�صķ���
	public static void swap(char[] c,int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	
	//ȫ����������
	public static void permutation(char[] c,int begin,int len){
		//�ݹ��˳���������������ֻ��һ��Ԫ����Ҫȫ����ʱ��ֱ��������鼴��
		if(begin == len){
			System.out.println(new String(c));
		} else{
			//��i�����ֱ�����������������õ��µ�ȫ����
			for(int i=begin; i<=len; i++){
				//ȥ�أ�beginֻ��������ķ��ظ������ֽ���
				if(isSwap(c, begin, i)){
					swap(c,begin,i);	//���������һ��Ԫ��index�ͺ����ĳ��Ԫ��x
					permutation(c,begin+1,len);		//beginԪ�صĺ���Ԫ�صݹ�ȫ����
					swap(c,begin,i);	//����һ�������˵�indexԪ�غ�xԪ�ػ�ԭ��ԭʼλ�ã�Ϊ��һ��ѭ����׼������һ��ѭ����Ҫ����index����һ��x��
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
