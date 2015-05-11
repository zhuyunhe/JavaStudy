package string;

public class RightMoveK {
	/**
	 * ��һ���ַ�������kλ
	 * �Ȱ��ַ���תΪһ���ַ����飬Ȼ�����k�����ÿ���ַ��������е���λ��
	 * @param s
	 * @param k
	 */
	public static String rightMoveKth(String s, int k){
		char[] c = s.toCharArray();
		
		int len = s.length();
		
		//�½�һ���ַ����鱣����
		char[] des = new char[len];
		
		//����ʵ��Ҫ�Ƶ�λ������Ϊk���ܴ���len
		k=k%len;
		
		for(int i=0; i<len; i++){
			des[(i+k)%len] = c[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<len; i++){
			sb.append(des[i]);
		}
		
		return sb.toString();
	}
	
	/**
	 * ��һ���ַ�������kλ
	 * �Ȱ��ַ���תΪһ���ַ����飬Ȼ�����k�����ÿ���ַ��������е���λ��
	 * @param s
	 * @param k
	 */
	public static String leftMoveKth(String s, int k){
		char[] c = s.toCharArray();
		
		int len = s.length();
		
		//�½�һ���ַ����鱣����
		char[] des = new char[len];
		
		//����ʵ��Ҫ�Ƶ�λ������Ϊk���ܴ���len
		k=k%len;
		
		for(int i=0; i<len; i++){
			des[i] = c[(i+k)%len];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<len; i++){
			sb.append(des[i]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		String s = "abcdefg";
		String rms = rightMoveKth(s, 2);
		System.out.println(rms);
		String lms = leftMoveKth(s, 2);
		System.out.println(lms);
	}
}
