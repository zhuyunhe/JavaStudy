package sort;

public class CountingSort {
	/**
	 * �������򣬽�ָoffer��65ҳ
	 * @param a
	 * @param length
	 */
	public static void countingSort(int[] a,int length,int range){
		if(a==null || length<=0){
			return;
		}
		//Ҫ������������ֵ
		int k = 4;
		
		int[] c = new int[k];
		
		for(int i=0; i<length; i++){
			int temp = a[i];
			
			c[temp-1]++;
		}
		
		int index = 0;
		for(int i=0; i<k; i++){
			for(int j=0; j<c[i];j++){
				//i+1����Ϊ�����±��0��ʼ����ʵ�����Ĵ�С����1���������
				a[index] = i+1;
				index++;
			}
		}
	}
	
	/**
	 * ���������㷨�������д��
	 * @param a
	 * @param length
	 */
	public static void countingSort2(int[] a,int length,int range){
		if(a==null || length<=0){
			return;
		}
		//Ҫ������������ֵ
		int k = range;
		
		int[] c = new int[k];
		
		for(int i=0; i<length; i++){
			int temp = a[i];
			
			c[temp-1]++;
		}
		
		//��������c
		for(int i=0; i<k-1; i++){
			c[i+1] += c[i];
		}
		
		int index = 0;
		int[] temp = new int[length];
		for(int i=a.length-1; i>=0; i--){
			int value = a[i];
			int position = c[value-1] - 1;
			
			temp[position] = value;
			c[value-1]--;
		}
		
		for(int i=0; i<a.length; i++){
			a[i] = temp[i];
		}
	}
	//�ҵ������������
	public static int findMax(int[] a){
		int maxIndex = 0;
		for(int i=0; i<a.length; i++){
			if(a[i]>a[maxIndex]){
				maxIndex = i;
			}
		}
		
		return a[maxIndex];
	}
	
	
	public static void main(String[] args){
		int[] a = {1,3,4,4,3};
		countingSort2(a, a.length,findMax(a));
		
		for(int i : a){
			System.out.println(i);
		}
	}
}
