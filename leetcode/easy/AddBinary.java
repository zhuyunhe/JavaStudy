package easy;

public class AddBinary {
	public static String addBinary(String a, String b) {
		int l1 = a.length() - 1;
		int l2 = b.length() - 1;
		//��λ
		int carry = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(l1>=0 || l2>=0 || carry!=0){
			//����ĳһλ������֮ǰ�Ľ�λ��1��0��
			int tem = (l1>=0 ? Integer.parseInt(a.charAt(l1--)+""):0)+(l2>=0 ? Integer.parseInt(b.charAt(l2--)+""):0)+carry;
			
			//�����λ
			carry = tem>=2? 1 : 0;
			
			//���ַ�������ǰ��������¼��������һλ
			sb.insert(0, tem%2==0 ? 0 : 1);
		}
		
        return sb.toString();
    }
	
	public static String addBinary_1(String a, String b) {
		int l1 = a.length() - 1;
		int l2 = b.length() - 1;
		
		//��λ
		int carry = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(l1>=0 || l2>=0 || carry!=0){
			//����ĳһλ������֮ǰ�Ľ�λ��1��0��
			int tem = (l1>=0 ? Integer.parseInt(a.charAt(l1--)+""):0)+(l2>=0 ? Integer.parseInt(b.charAt(l2--)+""):0)+carry;
			
			//�����λ
			carry = tem>=2? 1 : 0;
			
			//���ַ�������ǰ��������¼��������һλ
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
