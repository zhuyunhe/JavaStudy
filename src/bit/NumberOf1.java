package bit;

public class NumberOf1 {
	/**
	 * ��һ�����ĵ�λ��ʼ�ж�������Ķ����Ʊ�ʾ���м���1�������Ͳ����ܱ�־λӰ��
	 * @param n
	 * @return
	 */
	public static int numberOf1(int n){
		int count = 0;
		
		int flag = 1;
		
		while(flag>0){
			if((n&flag)>0){
				count++;
			}
			//flag����һλ
			flag = flag << 1;
		}
		
		return count;
	}
	
	/**
	 * ��һ��������ȥ1֮���ٺ�ԭ����������λ�����㣬�õ��Ľ���൱���ǰ������Ķ����Ʊ�ʾ�����ұ�һ��1���0
	 * @param n
	 * @return
	 */
	public static int numberOf1_2(int n){
		int count = 0;
		
		while(n>0){
			count++;
			n = n&(n-1);
		}
		
		return count;
	}
	
	public static void main(String[] args){
		System.out.println(numberOf1(7));
		System.out.println(numberOf1_2(7));

	}
}
