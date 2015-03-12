package easy;

public class AddBinary {
	public static String addBinary(String a, String b) {
		int l1 = a.length() - 1;
		int l2 = b.length() - 1;
		//进位
		int carry = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(l1>=0 || l2>=0 || carry!=0){
			//计算某一位，带着之前的进位（1或0）
			int tem = (l1>=0 ? Integer.parseInt(a.charAt(l1--)+""):0)+(l2>=0 ? Integer.parseInt(b.charAt(l2--)+""):0)+carry;
			
			//计算进位
			carry = tem>=2? 1 : 0;
			
			//在字符串的最前面插入最新计算出的那一位
			sb.insert(0, tem%2==0 ? 0 : 1);
		}
		
        return sb.toString();
    }
	
	public static String addBinary_1(String a, String b) {
		int l1 = a.length() - 1;
		int l2 = b.length() - 1;
		
		//进位
		int carry = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(l1>=0 || l2>=0 || carry!=0){
			//计算某一位，带着之前的进位（1或0）
			int tem = (l1>=0 ? Integer.parseInt(a.charAt(l1--)+""):0)+(l2>=0 ? Integer.parseInt(b.charAt(l2--)+""):0)+carry;
			
			//计算进位
			carry = tem>=2? 1 : 0;
			
			//在字符串的最前面插入最新计算出的那一位
			sb.insert(0, tem%2==0 ? 0 : 1);
		}
		
        return sb.toString();
    }
	
	public static void main(String[] args){
		String a = "110";
		String b = "11";
		
		String result = addBinary(a, b);
		System.out.println(result);
	}
}
