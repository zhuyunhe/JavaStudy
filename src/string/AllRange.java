package string;

public class AllRange {
	public static void permutation(String s){
		char[] c = s.toCharArray();
		permutation(c, 0, c.length-1);
	}
	
	public static String charToString(char[] c){
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		return sb.toString();
	}
	public static void swap(char[] c,int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	public static void permutation(char[] c,int begin,int len){
		//�ݹ��˳���������������ֻ��һ��Ԫ����Ҫȫ����ʱ��ֱ��������鼴��
		if(begin == len){
			System.out.println(charToString(c));
		} else{
			//��i�����ֱ�����������������õ��µ�ȫ����
			for(int i=begin; i<=len; i++){
				swap(c,begin,i);	//���������һ��Ԫ��index�ͺ����ĳ��Ԫ��x
				permutation(c,begin+1,len);		//beginԪ�صĺ���Ԫ�صݹ�ȫ����
				swap(c,begin,i);	//����һ�������˵�indexԪ�غ�xԪ�ػ�ԭ��ԭʼλ�ã�Ϊ��һ��ѭ����׼������һ��ѭ����Ҫ����index����һ��x��
			}
		}
		
	}
	
	public static void main(String[] args){
		permutation("123");
	}
}
