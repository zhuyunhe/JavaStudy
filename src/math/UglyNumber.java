package math;

public class UglyNumber {
	/**
	 * �ҳ�����С��������ĵ�index������
	 * @param index
	 * @return
	 */
	public static int getUglyNum(int index){
		if(index <= 0){
			return 0;
		}
		int[] a = new int[index];
		a[0] = 1;
		
		int next = 1;
		int m2 = 0;
		int m3 = 0;
		int m5 = 0;
		
		while(next < index){
			int min = min(a[m2]*2,a[m3]*3,a[m5]*5);
			
			//���min==[m2]*2,m2���λ����������ĳ���������һ�������ˣ��Ǿ͸���һ��m2��λ�á�ͬ���m3��m5
			if(a[m2]*2 == min){
				m2++;
			}
			
			if(a[m3]*3 == min){
				m3++;
			}
			
			if(a[m5]*5 == min){
				m5++;
			}
			a[next] = min;
			next++;
		}
		
		int ugly = a[next-1];
		return ugly;
		
	}
	
	public static int min(int a,int b,int c){
		int result = 0;
		if(a<b){
			result = a;
		} else{
			result = b;
		}
		if(c<result){
			result = c;
		}
		
		return result;
        /*//�ҵ�a,b֮����С��
        double temp = a < b ? a : b;
        //�ҵ�abc֮����С�ķ���
        return temp < c ? temp : c;*/
	}
	
	public static void main(String[] args){
		System.out.println(getUglyNum(3));
	}
}
