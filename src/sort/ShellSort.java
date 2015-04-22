package sort;

/**
 * ϣ�������ֽз������������С��������
 * �Ƚ���������Ԫ�����зָ�����ɸ������У������ĳ��������Ԫ����ɣ����ֱ���в�������
 * Ȼ���������������ٽ������򣬴����������е�Ԫ�ػ�������ʱ���ٶ�ȫ��Ԫ�ؽ���һ��ֱ�Ӳ�������
 * @author zhu
 *
 */
public class ShellSort {
	public static void shellSort(int[] a,int n){
		
		for(int gap=n/2; gap>0; gap/=2){
			for(int i=0; i<gap; i++){
				//��ʼ���������н��в�������
				for(int j=i+gap; j<n; j+=gap){
					if(a[j] < a[j-gap]){
						int temp = a[j];
						//ע���������
						for(int k=j-gap;k>=0&&a[k]>temp;k-=gap){
							a[k+gap] = a[k];
							a[k] = temp;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args){
    	int[] a = {4,3,2,1};
    	shellSort(a,a.length);
    	for(int n : a){
    		System.out.println(n);
    	}
    }
}
