package sort;

/**
 * ѡ������Ͳ����������ƣ��������ݷ�Ϊ��������������������ͬ���ǲ��������ǽ��������ĵ�һ��Ԫ��ֱ��
 * ���뵽�������γ�һ�����������������ֱ��ѡ�������Ǵ�������ѡһ����С��ֱ�ӷŵ������������
 * ����һ�ֲ��ȶ�������
 * @author zhu
 *
 */
public class SelectSort {
	public static void main(String[] args){
		int[] a = {0,3,2,1};
    	selectSort(a,a.length);
    	for(int n : a){
    		System.out.println(n);
    	}
	}
	
	public static void selectSort(int[] a,int n){
		int minIndex;
		int temp;
		//����������ѡһ����С��Ԫ�طŵ�����������󣬳�ʼʱ�������鶼����������ѡһ����С�ķŵ���һλ
		for(int i=0; i<n; i++){
			minIndex = i;
			//�ҳ���СԪ�ص��±�
			for(int j=i+1; j<n; j++){
				//�õ���СԪ�ص��±�
				if(a[j] < a[minIndex]){
					minIndex = j;
				}
			}
			//����λ�ã�����������ѡ������СԪ�طŵ������������
			temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}
}
