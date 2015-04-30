package array;

public class RotatedArrayMin {
	/**
	 * ����һ����������������һ����ת�������ת�������СԪ��
	 * @param a
	 * @param length
	 * @return
	 * @throws Exception 
	 */
	public static int min(int[] a, int length) throws Exception{
		if(a==null || length<=0){
			throw new Exception("range can't be negative or zero.");
		}
		
		int index1=0;
		int index2=length-1;
		int indexMid = index1;
		
		while(a[index1] >= a[index2]){
			if(index2-index1 == 1){
				indexMid = index2;
				break;
			}
			
			indexMid = (index1+index2)/2;
			
			//����±�Ϊindex1��index2��indexMid��Ԫ����ȣ�ֻ��˳�����
			if(a[index1] == a[index2] && a[index1] == a[indexMid]){
				findMin(a);
			}
			
			//�м�Ԫ�ش���index1Ԫ�أ�˵���м�Ԫ���ڵ�һ�����������У�������С����λ��������
			if(a[indexMid] >= a[index1]){
				index1 = indexMid;
			} //�м�Ԫ��С��index2Ԫ�أ�˵���м�Ԫ���ڵڶ������������У�������С����λ����ǰ����߾������Լ�
			else if(a[indexMid] <= a[index2]){
				index2 = indexMid;
			}
		}
		return a[indexMid];
	}
	
	//˳�������������С����
	public static int findMin(int[] a){
		int min=a[0];
		for(int i=0; i<a.length; i++){
			if(a[i]<min){
				min = a[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) throws Exception{
		int[] a ={0,1,2,3};
		
		System.out.println(min(a,a.length));
		System.out.println(findMin(a));
	}
}
