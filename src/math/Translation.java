package math;

public class Translation {
	/**
	 * �ж�һ���ַ����ǲ��ǻ���
	 * ʹ��ѭ����ͷβ��Ӧλ�����αȽ�
	 * @param s
	 * @return
	 */
	public static boolean isTranslation(String s){
		int len = s.length();
		if(len>0){
			char[] arr = s.toCharArray();
			for(int i=0; i<len/2; i++){
				if(arr[i] != arr[len-1-i]){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * ʹ�õݹ�˼��
	 * ÿ�μ���ȥ�����˵������ַ��������СҪ�����ַ����ķ�Χ
	 * ��Ҫ�����ַ����ķ�Χ�Ŀ��Ϊ1��0ʱ���ݹ��˳�
	 * @param s
	 * @param low
	 * @param high
	 * @param len
	 * @return
	 */
	public static boolean isTranslationRec(String s,int low, int high, int len){
		if(len == 0 || len==1){
			return true;
		}
		
		char[] arr = s.toCharArray();
		//�����ϻ�������������false
		if(arr[low] != arr[high]){
			return false;
		}
		
		return isTranslationRec(s, low+1, high-1, len-2);
		
	}
	
	public static void main(String[] args){
		String s = "aaabaaa";
		
		//���÷ǵݹ��ж�
		if(isTranslation(s)){
			System.out.println("s�ǻ���");
		} else{
			System.out.println("nonono");
		}
		
		//���õݹ��ж�
		if(isTranslationRec(s,0,s.length()-1,s.length())){
			System.out.println("s�ǻ���");
		} else{
			System.out.println("nonono");
		}
	}
}
