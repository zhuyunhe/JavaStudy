package string;

public class ReverseString {
	//�ݹ鷴תһ���ַ����е�ÿһ���ַ�
	public static String reverseRec(char[] c,int left,int right){
		if(c==null){
			return null;
		}
		
		//�ݹ��˳�����
		if(left>=right){
			return new String(c);
		}
		
		char temp = c[left];
		c[left] = c[right];
		c[right] = temp;
		
		return reverseRec(c, left+1, right-1);
	}
	
	//��תÿ�������е�ÿ������
	public static String reverse(String s){
		char[] arr = s.toCharArray();
		//�Ѿ����������ַ��ȷ�תһ��
		reverseRec(arr, 0, arr.length-1);
		
		int begin = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] == ' '){
				//��ÿ�����ʵ�˳������
				reverseRec(arr, begin, i-1);
				
				//����begin����һ�����ʿ�ʼ��λ��
				begin = i+1;
			}
		}
		
		return new String(arr);
	}
	
	public static void main(String[] args){
		String s = "abcd";
		System.out.println(reverseRec(s.toCharArray(), 0, s.length()-1));
		
		String juzi = "i love you";
		System.out.println(reverse(juzi));
	}
}
