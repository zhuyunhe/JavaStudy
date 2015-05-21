package array;

/**
 * ��ָoffer��44��
 * @author rttd
 *
 */
public class IsContinuous {
	public static void main(String[] args){
		int[] a = {1,4,3,6,0};
		if(isContinuous(a)){
			System.out.println("��˳��");
		}else{
			System.out.println("����˳��");
		}
	}
	
	public static void quickSort(int[] a,int left,int right){
		if(a==null || a.length<=1){
			return;
		}
		
		//�ݹ��������
		if(left>right){
			return;
		}
		
		int index = partition(a, left, right);
		
		quickSort(a, left, index-1);
		quickSort(a, index+1, right);
	}
	
	public static int partition(int[] a,int left,int right){
		int povit = a[left];
		int low = left;
		int high = right;
		
		while(low<high){
			while(low<high && a[high]>povit){
				high--;
			}
			if(low<high){
				a[low] = a[high];
			}
			while(low<high && a[low]<=povit){
				low++;
			}
			if(low<high){
				a[high] = a[low];
			}
		}
		
		a[low] = povit;
		
		return low;
	}
	
	public static boolean isContinuous(int[] a){
		if(a==null || a.length<1){
			return false;
		}
		
		quickSort(a, 0, a.length-1);
		
		int numOfZero = 0;	//������0�ĸ���
		for(int i=0; i<a.length; i++){
			if(a[i] == 0){
				numOfZero++;
			}
		}
		
		//�������ּ�Ŀ�ȱ��
		int numOfGap = 0;
		
		//�������������е���ʼλ��
		int small = numOfZero;
		int next = small+1;
		
		while(next<a.length){
			//������ֶ��ӣ��򲻿�����˳�ӣ�ֱ�ӷ���false
			if(a[small] == a[next]){
				return false;
			}
			numOfGap += a[next] - a[small] - 1;
			small = next;
			next++;
		}
		
		return numOfZero>=numOfGap?true:false;
	}
}
