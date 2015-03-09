package medium;

public class ReverseBits {
	public static void main(String[] args){
		int a = 43261596;
		
		int b = reverseBits_1(a);
		
		System.out.println(b);
		
		
	}
	
	/**
	 * 翻转一个整数的二进制位得到一个新的整数
	 * @param n
	 * @return
	 */
    public static int reverseBits(int n) {
    	int result = 0;
    	
    	for(int i=0; i<32; i++){
    		//result先左移一位，然后取出输入n的二进制的最后一位(n & 1),用|操作把n最后一位加入result
    		result = (result << 1) | (n & 1);
    		
    		//输入n右移，抛弃掉最后一位
    		n >>= 1;
    	}
		return result;
        
    }
    
    /**
     * 改进版算法，靠移位完成
     * 中心思想是把各个位分成组，一次性交换所有两两相邻的组。然后再通过改变交换组的大小让每个位最终到达它需要去的地方。
     * @param n
     * @return
     */
    public static int reverseBits_1(int n) {
		int result = 0;
		
		//相邻两位互换
		n = ((n>>1) & 0x55555555)|((n&0x55555555)<<1);
		
		//每四位中的前两位和后两位互换
		n = ((n>>2) & 0x33333333)|((n&0x33333333)<<2);
		
		//每八位中的前四位和后四位互换
		n = ((n>>4) & 0x0F0F0F0F)|((n&0x0F0F0F0F)<<4);
		
		//每16位中的前八位和后八位互换
		n = ((n>>8) & 0x00FF00FF)|((n&0x00FF00FF)<<8);
		
		//前十六位和后十六位互换，交换完成
		n = (n>>16)|(n<<16);
		
    	return n;
	}
    
    /**
     * 倒置字符串
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
