package string;

public class RightMoveK {
	/**
	 * 把一个字符串右移k位
	 * 先把字符串转为一个字符数组，然后根据k计算出每个字符在数组中的新位置
	 * @param s
	 * @param k
	 */
	public static String rightMoveKth(String s, int k){
		char[] c = s.toCharArray();
		
		int len = s.length();
		
		//新建一个字符数组保存结果
		char[] des = new char[len];
		
		//计算实际要移的位数，因为k可能大于len
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
	 * 把一个字符串左移k位
	 * 先把字符串转为一个字符数组，然后根据k计算出每个字符在数组中的新位置
	 * @param s
	 * @param k
	 */
	public static String leftMoveKth(String s, int k){
		char[] c = s.toCharArray();
		
		int len = s.length();
		
		//新建一个字符数组保存结果
		char[] des = new char[len];
		
		//计算实际要移的位数，因为k可能大于len
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
