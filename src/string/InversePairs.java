package string;

public class InversePairs {
	public static void main(String[] args){
		int[] a ={7,5,6,4};
		int[] temp = new int[a.length];
		System.out.println(inversePairs(a,temp,0,a.length-1));
	}
	
	public static int inversePairs(int[] a,int[] temp,int start,int end){
		if(a==null || a.length<=0){
			return 0;
		}
		if(start==end){
			temp[start] = a[start];
			return 0;
		}
		int middle = (start+end)/2;
		
		int left = inversePairs(a, temp, start, middle);
		int right = inversePairs(a, temp, middle+1, end);
		
		//i��ʼ��Ϊǰ�����������һ��Ԫ���±�
		int i = middle;
		
		//j��ʼ��Ϊ������������һ��Ԫ�ص��±�
		int j = end;
		
		int indexCopy = end;
		
		//��¼�������
		int count = 0;
		
		while(i>=start && j>=start+middle+1){
			if(a[i] > a[j]){
				temp[indexCopy--] = a[i--];
				count += j-(start+middle);
			} else{
				temp[indexCopy--] = a[j--];
			}
		}
		
		while(i>=start){
			temp[indexCopy--] = a[i--];
		}
		while(j>=start+middle+1){
			temp[indexCopy--] = a[j--];
		}
		
		return count+left+right;
	}
}
