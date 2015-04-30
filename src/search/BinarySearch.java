package search;

public class BinarySearch {
	/**
	 * ����ʵ�ֶ��ֲ���
	 * ���ֲ����ֳ��۰���ң�����һ��Ч�ʽϸߵĲ��ҷ����� 
	 * �����ֲ���Ҫ�󡿣�1.�������˳��洢�ṹ 2.���밴�ؼ��ִ�С�������С�
	 * @param a
	 * @param des
	 * @return
	 */
	public static int binarySearch(int[] a, int des){
		int low = 0;
		int high = a.length-1;
		int middle = 0;
		while(low <=high){
			middle = (low+high)/2;
			
			if(des == a[middle]){
				return a[middle];
			} else if(des < a[middle]){
				high = middle -1;
			} else{
				low = middle +1;
			}
			
		}
		return -1;
	}
	
	/**
	 * �ݹ�ʵ�ֶ��ֲ���
	 * @param a
	 * @param des
	 * @param left
	 * @param right
	 * @return
	 */
	public static int binarySearchRec(int[] a, int des, int left, int right){
		if(left <= right){
			int middle = (left+right)/2;
			
			if(a[middle] == des){
				return a[middle];
			} else if(des < a[middle]){
				return binarySearchRec(a, des, left, middle-1);
			} else{
				return binarySearchRec(a, des, middle+1, right);
			}
		} else{
			return -1;
		}
	}
	
	/**
	 * �������ֲ��������е�һ��des��λ��
	 * @param a
	 * @param des
	 * @return
	 */
	public static int binarySearchFirstPos(int[] a, int des){
		int low = 0;
		int high = a.length-1;
		int middle = 0;
		while(low <= high){
			middle = (low+high)/2;
			//����м����ֺ�des���
			if(des == a[middle]){
				//�ж�����м����ǲ��ǵ�һ��des
				//�������м�����ǰһ����������des����˵����һ��des�����м�����
				if(middle>0&&a[middle -1] != des || middle == 0){
					return middle;
					
				} else{ //�������м�����ǰһ��������des����˵����һ��des�������ǰ�벿��
					high = middle - 1;
				}
			}
			//����м�������des��desֻ���ܳ����������ǰ���
			else if(a[middle] > des){
				high = middle - 1;
			} else{
				low = middle + 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * �ݹ���ֲ��������е�һ��des��λ��
	 * @param a
	 * @param des
	 * @param left
	 * @param right
	 * @return
	 */
	public static int binarySearchFirstPosRec(int[] a, int des, int left, int right){
		if(left>right){
			return -1;
		}
		
		int middle = (left+right)/2;
		
		if(a[middle] == des){
			if(middle>0&&a[middle-1]!=des || middle==0){
				return middle;
			}
			else{
				right = middle-1;
			}
		} else if(a[middle] > des){
			right = middle - 1;
		} else{
			left = middle + 1;
		}
		
		return binarySearchFirstPosRec(a, des, left, right);
	}
	
	/**
	 * �ݹ���ֲ������������һ��des��λ��
	 * @param a
	 * @param des
	 * @param left
	 * @param right
	 * @return
	 */
	public static int binarySearchLastPosRec(int[] a, int des, int left, int right){
		if(left>right){
			return -1;
		}
		
		int middle = (left+right)/2;
		
		if(a[middle] == des){
			if(middle<a.length-1&&a[middle+1]!=des || middle==a.length-1){
				return middle;
			}
			else{
				left = middle+1;
			}
		} else if(a[middle] > des){
			right = middle - 1;
		} else{
			left = middle + 1;
		}
		
		return binarySearchLastPosRec(a, des, left, right);
	}
	
	/**
	 * �������ֲ������������һ��des��λ��
	 * @param a
	 * @param des
	 * @return
	 */
	public static int binarySearchLastPos(int[] a, int des){
		int low = 0;
		int high = a.length-1;
		int middle = 0;
		
		while(low <= high){
			middle = (low+high)/2;
			if(a[middle] == des){
				//�ж�����м����ǲ������һ��des
				//�������м����ĺ�һ����������des����˵�����һ��des�����м�����
				if(middle<a.length-1&&a[middle+1]!=des || middle==a.length-1){
					return middle;
				} else{ //�������м����ĺ�һ��������des����˵�����һ��des������ĺ�벿��
					low = middle+1;
				}
			}
			//�������м���С��des��˵�����һ��des�������벿��
			else if(a[middle] < des){
				low = middle + 1;
			} else{
				high = middle - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,3,3,3,3,4,5,6};
		//���ֲ���
		System.out.println(binarySearch(a, 3));
		System.out.println(binarySearchRec(a, 3, 0, a.length-1));
		
		//���ֲ���des��һ�γ��ֵ�λ��
		System.out.println(binarySearchFirstPos(a, 3));
		System.out.println(binarySearchFirstPosRec(a, 3, 0, a.length-1));
		
		//���ֲ���des���һ�γ��ֵ�λ��
		System.out.println(binarySearchLastPos(a, 3));
		System.out.println(binarySearchLastPosRec(a, 3, 0, a.length-1));
		int count = binarySearchLastPosRec(a, 3, 0, a.length-1)-binarySearchFirstPos(a, 3)+1;
		System.out.println("offer38��");
		System.out.println("�����й���"+count+"��3");
	}
	
}
