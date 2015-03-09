package medium;

public class ReverseBits {
	public static void main(String[] args){
		int a = 43261596;
		
		int b = reverseBits_1(a);
		
		System.out.println(b);
		
		
	}
	
	/**
	 * ��תһ�������Ķ�����λ�õ�һ���µ�����
	 * @param n
	 * @return
	 */
    public static int reverseBits(int n) {
    	int result = 0;
    	
    	for(int i=0; i<32; i++){
    		//result������һλ��Ȼ��ȡ������n�Ķ����Ƶ����һλ(n & 1),��|������n���һλ����result
    		result = (result << 1) | (n & 1);
    		
    		//����n���ƣ����������һλ
    		n >>= 1;
    	}
		return result;
        
    }
    
    /**
     * �Ľ����㷨������λ���
     * ����˼���ǰѸ���λ�ֳ��飬һ���Խ��������������ڵ��顣Ȼ����ͨ���ı佻����Ĵ�С��ÿ��λ���յ�������Ҫȥ�ĵط���
     * @param n
     * @return
     */
    public static int reverseBits_1(int n) {
		int result = 0;
		
		//������λ����
		n = ((n>>1) & 0x55555555)|((n&0x55555555)<<1);
		
		//ÿ��λ�е�ǰ��λ�ͺ���λ����
		n = ((n>>2) & 0x33333333)|((n&0x33333333)<<2);
		
		//ÿ��λ�е�ǰ��λ�ͺ���λ����
		n = ((n>>4) & 0x0F0F0F0F)|((n&0x0F0F0F0F)<<4);
		
		//ÿ16λ�е�ǰ��λ�ͺ��λ����
		n = ((n>>8) & 0x00FF00FF)|((n&0x00FF00FF)<<8);
		
		//ǰʮ��λ�ͺ�ʮ��λ�������������
		n = (n>>16)|(n<<16);
		
    	return n;
	}
    
    /**
     * �����ַ���
     * @param str
     * @return
     */
    private static String reverseString(String str){
    	char[] charArr = str.toCharArray();
    	int size = str.length();
    	int medium = size >> 1;
    	int last = size - 1;
    	for(int i=0; i<medium; i++){
    		char temp = charArr[last -i];
    		charArr[last -i] = charArr[i];
    		charArr[i] = temp;
    	}
		return new String(charArr);
    	
    }
}
