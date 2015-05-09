package binhexoct;

/**
 * һ�����ת������10������Ϊ�������У�ת��Ϊ2���ƣ�8���ƻ�16����
 * Java�����ͷ�װ��Integer��Long�ṩtoString(int i,int radix)��̬���������Խ�һ��������Ƶ�����ת��Ϊ�������Ƶ�������
 * @author zhu
 *
 */
public class Convert {
	/**
	 * ʮ����ת������
	 * Ҳ����ʹ��Integer��Long��toBinaryString����������ת��Ϊ�����ơ�
	 * @param num
	 */
	public static void toBin1(int num){
		//��һ���ɱ���ַ�����������ת�����
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num%2);
			num /=2;
		}
		//��ת�õ���ȷ��˳��Ҳ������ջ�������εõ��ĸ������������pop��
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * ʮ����ת������
	 * @param num
	 */
	public static void toBin2(int num){
		//��һ���ɱ���ַ�����������ת�����
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num&1);
			//�޷�������һλ
			num = num >>> 1;
		}
		//��ת�õ���ȷ��˳��Ҳ������ջ�������εõ��ĸ������������pop��
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * ʮ����ת�˽���
	 * Ҳ����ʹ��Integer��Long��toOctalString����������ת��Ϊ�˽��ơ�
	 * @param num
	 */
	public static void toOct1(int num){
		//��һ���ɱ���ַ�����������ת�����
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num%8);
			num /=8;
		}
		//��ת�õ���ȷ��˳��Ҳ������ջ�������εõ��ĸ������������pop��
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * ʮ����ת�˽���
	 * @param num
	 */
	public static void toOct2(int num){
		//��һ���ɱ���ַ�����������ת�����
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num&7);
			//�޷�������һλ
			num = num >>> 3;
		}
		//��ת�õ���ȷ��˳��Ҳ������ջ�������εõ��ĸ������������pop��
		sb.reverse();
		System.out.println(sb.toString());
	}
	/**
	 * ʮ����תʮ������
	 * Ҳ����ʹ��Integer��Long��toHexString����������ת��Ϊʮ�����ơ�
	 * @param num
	 */
	public static void toHex1(int num){
		//��һ���ɱ���ַ�����������ת�����
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			int temp = num%16;
			if(temp > 9){
				//ע��Ҫ��intתΪchar
				sb.append((char)('A'+temp-10));
			} else{
				sb.append(temp);
			}
			num /=16;
		}
		//��ת�õ���ȷ��˳��Ҳ������ջ�������εõ��ĸ������������pop��
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * ʮ����תʮ������
	 * @param num
	 */
	public static void toHex2(int num){
		//��һ���ɱ���ַ�����������ת�����
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			int temp = num%16;
			if(temp > 9){
				//ע��Ҫ��intתΪchar
				sb.append((char)('A'+temp-10));
			} else{
				sb.append(temp);
			}
			//�޷�������һλ
			num = num >>> 4;
		}
		//��ת�õ���ȷ��˳��Ҳ������ջ�������εõ��ĸ������������pop��
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	public static void change(int num,int base, int offset){
        //ͨ������������ģ��ı��
		char[] chs = {	'0','1','2','3'
						,'4','5','6','7'
						,'8','9','A','B'
						,'C','D','E','F'};
		char[] arr = new char[32];
		int len = arr.length;  
		//ͨ��ѭ�����ת��
		    while(num!=0){
		        int temp = num & base;
		        arr[--len]=chs[temp];
		        num = num>>>offset;
		    }
		    for(int i=0;i<arr.length;i++){
		    	//���ַ��Ͳ�����
		    	if(arr[i] != '\0'){
		    	System.out.print(arr[i]);
		    	}
		    }
}
	public static void main(String[] args){
		int a = 12;
		toBin1(a);
		toBin2(a);
		toOct1(a);
		toOct2(a);
		toHex1(a);
		toHex2(a);
		change(a,15,4);
	}
}
