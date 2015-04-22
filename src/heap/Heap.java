package heap;

/**
 * ����ѵ����ʣ�
 * ������ֵ���Ǵ��ڵ��ڣ���С�ڵ��ڣ��ӽڵ��ֵ
 * ÿ������������������������һ�������
 * @author zhu
 *
 */
public class Heap {
	/**
	 * ���ǣ����ڶ�����
	 * @param a
	 * @param i �¼�����������±�
	 */
	public static void minHeapFixup(int[] a, int i){
		int j,temp;
		temp = a[i];
		
		//�ҵ����ڵ�
		j = (i-1)/2;
		
		while(j>=0&&i!=0){
			//������ڵ�С��Ҫ����Ľ�㣬�ǲ���������������ѭ��
			if(a[j] <= temp){ 
				break;
			}
			//�Ѹ��ڵ��ֵ�ŵ��������±�Ϊi��λ�ã�������i��j
			a[i] = a[j];
			i = j;
			j = (i-1)/2;
		}
		
		a[i] = temp;
	}
	
	public static void minHeapAddNumber(int[] a,int n, int nNum){
		a[n] = nNum;
		minHeapFixup(a,n);
	}
	
	/**
	 * ��С�����ǣ����ڶ�ɾ��
	 * ����ÿ��ɾ��ֻ��ɾ����0������,Ҳ���Ƕѵø��ڵ�Ԫ��
	 * ɾ�������ڸ����γ���һ����Ѩ������Ҫ����Ѩ���������ӵĽ�С�������Ѩ
	 * �����Ͱѿ�Ѩ��������һ�㣬�ظ��ò�ֱ���ѵ����һ��Ԫ�ؿ��Է����Ѩ��
	 * @param a
	 * @param i
	 * @param n
	 */
	public static void minHeapFixdown(int a[],int i,int n){
		int j,temp;
		
		temp = a[i];
		j = 2*i + 1;
		while(j<n){
			//�����Һ���������С��
			if(j+1<n && a[j+1]<a[j]){
				j++;
			}
			
			if(a[j]>=temp){
				break;
			}
			
			//�ѽ�С���ӽڵ������ƶ����滻���ĸ��ڵ�
			a[i] = a[j];
			i=j;
			j=2*i+1;
		}
		
		a[i] = temp;
		
	}
	
	/**
	 * ���ѵ����ǣ��������ݽṹ���㷨��������190ҳд��
	 * @param a
	 * @param i
	 * @param n
	 */
	public static void maxHeapFixdown(int[] a,int i,int n){
		int child;
		int temp;
		
		for(temp=a[i];leftChild(i)<n;i=child){
			child = leftChild(i);
			
			//�ҳ������ӽڵ��нϴ��
			if(child!=n-1 && a[child]<a[child+1]){
				child++;
			}
			
			//���ڵ���ϴ�Ľڵ�Ƚ�
			//������ڵ�С�����ϴ���ӽڵ㣬��ô�ӽڵ������滻���ڵ�
			if(temp<a[child]){
				a[i] = a[child];
			} else{ //������ڵ�������ӽڵ㣬�ǲ����仯
				break;
			}
		}
		
		//��tempԪ�طŵ�����Ǹ���������Ԫ�ص�λ����
		a[i] = temp;
	}
	
	/**
	 * ���������ڲ�ʹ�õĺ���
	 * @param i
	 * @return
	 */
	public static int leftChild(int i){
		return 2*i+1;
	}
	
	/**
	 * ɾ����Ԫ��
	 * @param a
	 * @param n
	 */
	public static void minHeapDeleteNumber(int a[],int n){
		swapReference(a,0,n-1);
		minHeapFixdown(a, 0, n-1);
	}
                       
	/**
	 * ��������������λ����Ԫ�ص�ֵ
	 * @param a Ŀ������
	 * @param i
	 * @param j
	 */
	public static void swapReference(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * ������С��
	 * @param a
	 * @param n
	 */
	public static void makeMinHeap(int a[],int n){
		for(int i=n/2-1;i>=0;i--){
			minHeapFixdown(a, i, n);
		}
	}
	
	/**
	 * ��������
	 * @param a
	 * @param n
	 */
	public static void makeMaxHeap(int[] a,int n){
		for(int i=n/2-1;i>=0;i--){
			maxHeapFixdown(a, i, n);
		}
	}
	
	/**
	 * ������С������
	 * @param a
	 * @param n
	 */
	public static void minHeapSort(int[] a,int n){
		//������С��
		makeMinHeap(a, a.length);
		
		for(int i=n-1; i>=1; i--){
			//deleteMin,����С�ѵĸ��ڵ㣬Ҳ������С��Ԫ�طŵ��������
			swapReference(a,0,i);
			
			//����Ԫ�����»ָ�����
			minHeapFixdown(a, 0, i);
		}
	}
	
	public static void maxHeapSort(int[] a,int n){
		//��������
		makeMaxHeap(a, a.length);
		
		for(int i=n-1; i>=1; i--){
			//deleteMax,�����ѵĸ��ڵ㣬Ҳ��������Ԫ�طŵ��������
			swapReference(a,0,i);
			
			//����Ԫ�����»ָ�����
			maxHeapFixdown(a, 0, i);
		}
	}
	
	//����
	public static void main(String[] args){
		int[] a = {34,8,64,51,32,21};
		
		//������С������
		minHeapSort(a, a.length);
		for(int i : a){
			System.out.print(i+",");
		}
		
		System.out.println();
		
		//������������
		maxHeapSort(a, a.length);
		for(int i : a){
			System.out.print(i+",");
		}
		
	}
}
