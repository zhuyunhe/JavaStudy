package array;

public class Reorder {
	/**
	 * ��������˳��ʹ����λ��ż��ǰ��
	 * ����ָ�룬һ��λ������ͷ��ʼ������ƶ�ֱ����ָ��ż��
	 * һ��λ������β����ǰ�ƶ�ֱ����ָ������
	 * ����λ��
	 * @param a
	 */
	public static void reorder(int[] a){
		if(a == null){
			return;
		}
		
		int begin = 0;
		int end = a.length-1;
		
		while(begin<end){
			//beginλ���������������begin++
			while(begin<end && !isEven(a[begin])){
				begin++;
			}

			//endλ���������ż����end--
			while(begin<end && isEven(a[end])){
				end--;
			}
			
			if(begin<end){
				swap(a, begin, end);
			}
		}
	}
	
	/**
	 * ��������������λ����Ԫ�ص�ֵ
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * �ж�һ�����Ƿ�Ϊż��
	 * @param n
	 * @return
	 */
	public static boolean isEven(int n){
		return (n&0x01)==0;
	}
	
	public static void main(String[] args){
		int[] a = {2,3,4,1,6,7,8,3};
		reorder(a);
		for(int k :a){
			System.out.println(k);
		}
	}
}
