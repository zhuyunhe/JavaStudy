package maxSubSum;

/**
 * ��ָoffer31��
 * @author zhu
 *
 */
public class MaxSubSum {
	
	/**
	 * ö�ٳ�����������
	 * ʱ�临�Ӷ�ΪO(N^3)
	 * @param array
	 * @return
	 */
	public static int maxSubSum_1(int[] array){
		int maxSum = 0;
		for(int i=0; i<array.length; i++){
			for(int j=i; j<array.length; j++){
				int tempSum = 0;
				//��i��j��Ԫ����ӣ�����i��j������еĺͣ������[i,j]��Ϊһ����λ
				for(int k=i; k<=j; k++){
					tempSum += array[k];
				}
				
				if(tempSum > maxSum){
					maxSum = tempSum;
					}
			}
		}
		
		return maxSum;
	}
	
	/**
	 * ȥ������1�����ڴ�ѭ������ÿ��Ԫ��Ϊһ����λ��ֱ�����������ӷ�
	 * @param array
	 * @return
	 */
	public static int maxSubSum_2(int[] array){
		int maxSum = 0;
		for(int i=0; i<array.length; i++){
			int tempSum = 0;
			for(int j=i; j<array.length; j++){
				tempSum += array[j];
				if(tempSum > maxSum){
					maxSum = tempSum;
				}
			}
			
		}
		return maxSum;
		
	}
	
	/**
	 * ���β��ԣ���Ϊ����������
	 * ������������Σ��������������ߣ�������������ұߣ����ߺ�����ң�����������һ��Ԫ�ص�����������ұߵ�һ��Ԫ�ص����͵ĺͣ�
	 * ʱ�临�Ӷȣ�O(N*LogN)
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int maxSubSum_3(int[] array,int left,int right){
		
		//�ֽ⵽�������������ɼ����ֽ�
		if(left == right){
			if(array[left] >0){
				return array[left];
			} else{
				return 0;
			}
		}
		
		int center = (left+right)/2;
		int maxLeftSum = maxSubSum_3(array, left, center);
		int maxRightSum = maxSubSum_3(array, center+1, right);
		
		//���������center�����ֵ��Ȼ���ж�����1��2��3
		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;
		for(int i=center; i>=left;i--){
			leftBorderSum += array[i];
			
			if(leftBorderSum > maxLeftBorderSum){
				maxLeftBorderSum = leftBorderSum;
			}
		}
		
		int maxRightBorderSum = 0;
		int rightBorderSum = 0;
		for(int i=center+1; i<=right;i++){
			rightBorderSum += array[i];
			
			if(rightBorderSum > maxRightBorderSum){
				maxRightBorderSum = rightBorderSum;
			}
		}
		
		int borderSum = maxLeftBorderSum + maxRightBorderSum;
		
		int maxSum = max3(maxLeftSum,maxRightSum,borderSum);
		return maxSum;
	}
	
	public static int max3(int a, int b, int c){
		if(a>b){
			b=a;
		}
		if(b>c){
			c=b;
		}
		
		return c;
	}
	
	/**
	 * һ�������������һ��������ô�õ��Ľ��һ����ԭ��С��
	 * �������ǿ�������������ÿ�μ������µ�Ԫ�أ�����maxSum���бȽϣ���������������ֵ��maxSum�����С��maxSum������0����maxSum���䣬����ѭ��������������С��0����ô�ʹ��¿�ʼ
	 * ����ʵҲ��һ�ֶ�̬�滮
	 * ʱ�临�Ӷȣ�O(N)
	 * @param array
	 * @return
	 */
	public static int maxSubSum_4(int[] array){
		int maxSum = 0;
		int tempSum = 0;
		
		for(int i=0; i<array.length; i++){
			if(tempSum <= 0){
				tempSum = array[i];
			} else{
				tempSum += array[i];
			}
			
			if(tempSum > maxSum){
				maxSum = tempSum;
			}
		}
		
		return maxSum;
	}
	public static int maxSubSum_5(int[] array){
		int maxSum = 0;
		int tempSum = 0;
		
		for(int i=0; i<array.length; i++){
			tempSum += array[i];
			if(tempSum > maxSum){
				maxSum = tempSum;
			} else if(tempSum < 0){
				tempSum = 0;
			}
		}
		
		return maxSum;
	} 
	
	public static void main(String[] args){
		int[] array = {-2,11,-4,13,-5,-2};
		
		int maxSum_1 = maxSubSum_1(array);
		
		System.out.println("�ⷨһ��"+maxSum_1);
		
		int maxSum_2 = maxSubSum_2(array);
		
		System.out.println("�ⷨ����"+maxSum_2);

		int maxSum_3 = maxSubSum_3(array, 0, 5);
		
		System.out.println("�ⷨ����"+maxSum_3);

		int maxSum_4 = maxSubSum_4(array);
		
		System.out.println("�ⷨ�ģ�"+maxSum_4);
		
		int maxSum_5 = maxSubSum_5(array);
		
		System.out.println("�ⷨ�壺"+maxSum_5);
	}
}
