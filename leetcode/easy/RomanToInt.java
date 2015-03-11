package easy;

public class RomanToInt {
	/**
	 * ��������ת����
	 * �����������Ҽ����
	 * �������ֹ���7������I(1)��V(5)��X(10)��L(50)��C(100)��D(500)��M(1000)
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		if(s==null || s.equals("")){
			return 0;
		}
		
		int result = 0;
		//�����һ���������ֵ�ֵ��Ϊ��ʱ����
		int sub = getRomanValue(s.charAt(0));
		
		int tem = sub;
		
		for(int i=1; i<s.length(); i++){
			//�õ���ǰ��λ��ֵ
			tem = getRomanValue(s.charAt(i));
			
			//��ߵ����ұ�
			if(tem == sub){
				sub += tem;
			} else if(sub>tem){ //��ߴ����ұ�,�Ȱ���߼ӵ������ȥ
				result += sub;
				sub = tem;
			} else{ //���С���ұ�
				sub = tem - sub;
			}
		}
		
		result += sub;
		
		
		return result;
    }
	public static int getRomanValue(char c) {  
        switch(c) {  
            case 'I': return 1;   
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0;  
        }  
    }  
	public static void main(String[] args){
		String s = "XCIX";
		System.out.println(romanToInt(s));
	}
}
