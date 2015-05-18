package array;

/**
 * ͳ��һ�����������������г��ֵĴ���
 * @author rttd
 *
 */
public class GetNumOfK {
	public static void main(String[] args){
		int[] a = {1,2,3,3,3,3,3,5,6,8,9,10};
		int first = getFirstK(a, 3);
		int last = getLastK(a, 3);
		System.out.println("3��������һ��������"+(last-first+1)+"��");
		
		int first2 = getFirstKRec(a, 3,0,a.length-1);
		int last2 = getLastKRec(a, 3, 0, a.length-1);
		System.out.println("3��������һ��������"+(last2-first2+1)+"��");
	}
	
	/**
	 * �����Ķ��ַ���������������ĳ������һ�γ��ֵ�λ��
	 * @param a
	 * @param des
	 * @return
	 */
	public static int getFirstK(int[] a, int des){
		if(a == null){
			return -1;
		}
		
		int start = 0;
		int end = a.length-1;
		int middle = 0;
		
		while(start <= end){
			middle = (start+end)/2;
			
			//���middle���õ���des���ж��ǲ��������еĵ�һ��des
			if(des == a[middle]){
				
				//middle�����������е�һ��des
				if(middle>0&&a[middle-1]!=des || middle==0){
					return middle;
				} else{
					end = middle-1;
				}
			} else if(des > a[middle]){	//des > a[middle]˵�������е�һ��des������middle���ұ�
				start = middle+1;
			} else{	//des < a[middle]˵�������е�һ��des������middle�����
				end = middle-1;
			}
		}
		
		return -1;
	}
	
	/**
	 * �ݹ�Ķ��ַ���������������ĳ������һ�γ��ֵ�λ��
	 * @param a
	 * @param des
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getFirstKRec(int[] a,int des,int start,int end){
		if(a==null || start>end){
			return -1;
		}
		
		int middle = (start+end)/2;
		//���middle���õ���des���ж��ǲ��������еĵ�һ��des
		if(a[middle] == des){
			//���middle�����������е�һ��des��λ�ã�ֱ�ӷ���middle
			if(middle>0&&a[middle-1]!=des || middle==0){
				return middle;
			} else{	//˵��des��һ���������г��ֵ�λ����middle���
				end = middle-1;
			}
		} else if(a[middle] < des){	//a[middle] < des˵��des��һ���������г��ֵ�λ����middle�ұ�
			start = middle + 1;
		} else{	//a[middle]>des˵��des��һ���������г��ֵ�λ����middle�����
			end = middle - 1;
		}
		
		//�ݹ����
		return getFirstKRec(a, des, start, end);
	}
	/**
	 * �����Ķ��ַ���������������ĳ�������һ�γ��ֵ�λ��
	 * @param a
	 * @param des
	 * @return
	 */
	public static int getLastK(int[] a, int des){
		if(a==null){
			return -1;
		}
		
		int start = 0;
		int end = a.length-1;
		int middle = 0;
		
		while(start <= end){
			middle = (start+end)/2;
			//���middle���õ���des���ж��ǲ��������е����һ��des
			if(des == a[middle]){
				//���middle���������������һ��des��λ�ã�ֱ�ӷ���middle
				if(a[middle+1]!=des&&middle<a.length-1 || middle==a.length-1){
					return middle;
				} else{
					start = middle+1;
				}
			} else if(des > a[middle]){	//des > a[middle]˵��des�������������ֵ�λ����middle���ұ�
				start = middle+1;
			}else{	//des < a[middle]˵��des�������������ֵ�λ����middle�����
				end = middle - 1;
			}
		}
		
		return -1;
	}
	/**
	 * �ݹ�Ķ��ַ���������������ĳ�������һ�γ��ֵ�λ��
	 * @param a
	 * @param des
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getLastKRec(int[] a,int des,int start,int end){
		if(a==null || start>end){
			return -1;
		}
		
		int middle = (start+end)/2;
		//���middle���õ���des���ж��ǲ��������е����һ��des
		if(a[middle] == des){
			//���middle���������������һ��des��λ�ã�ֱ�ӷ���middle
			if(middle<a.length-1&&a[middle+1]!=des || middle==a.length-1){
				return middle;
			} else{	//˵��des���һ���������г��ֵ�λ����middle�ұ�
				start = middle+1;
			}
		} else if(a[middle] < des){	//a[middle] < des˵��des�����һ���������г��ֵ�λ����middle�ұ�
			start = middle + 1;
		} else{	//a[middle]>des˵��des���һ���������г��ֵ�λ����middle�����
			end = middle - 1;
		}
		
		//�ݹ����
		return getLastKRec(a, des, start, end);
	}
}
