package string;

import javax.management.RuntimeErrorException;


public class Print1ToMaxOfNDigits {
	
	/**
	 * ���õݹ��ȫ����
	 * ��˳���ӡ��1������nλ��
	 * @param n ���ֵ����λ��
	 */
	public static void print1ToNthRec(int n){
		if(n<1){
			throw new RuntimeException("�������");
		}
		
		int[] arr = new int[n];
		
		//������ĵ�0λ��ʼ����
		print1ToNth(0,arr);
	}
	
	public static void print1ToNth(int n,int[] arr){
		//�ݹ���ֹ��������n������arr����ĳ���ʱ��˵�������Ѿ����
		if(n >= arr.length){
			printArray(arr);
		} else{
			//������ĸ�λ��ʼ������ĸ�λ(���ұ���һλ)�൱��������ĵ�λ�����������ÿһλ����0��9����һ�飬�͵õ������е�ʮ������
			for(int i=0; i<=9; i++){
				arr[n] = i;
				print1ToNth(n+1, arr);
			}
		}
	}
	
	/** 
     * ���������Ԫ�أ������ң��ӵ�һ����0ֵ����ʼ���������Ԫ�ء� 
     * 
     * @param arr Ҫ��������� 
     */  
    public static void printArray(int[] arr) {  
        // �ҵ�һ����0��Ԫ��  
        int index = 0;  
        while (index < arr.length && arr[index] == 0) {  
            index++;  
        }  
  
        // �ӵ�һ����0ֵ����ʼ���������Ԫ�ء�  
        for (int i = index; i < arr.length; i++) {  
            System.out.print(arr[i]);  
        }  
        // ��������˵���������з���Ԫ�أ�������Ҫ����  
        if (index < arr.length) {  
            System.out.println();  
        }
    }
    
    /**
     * ��������ģ�����ֵļӷ�
     * @param n
     */
    public static void print1ToNth(int n){
    	if(n < 1){
    		throw new RuntimeException("�������");
    	}
    	
    	
    	int[] arr = new int[n];
    	
    	for(int i=0; i<arr.length; i++){
    		arr[i] = 0;
    	}
    	
    	//������λû�н�λ��һֱ����
    	while(!addOne(arr)){
    		printArray(arr);
    	}
    }
    
    public static boolean addOne(int[] arr){
    	int carry = 0;		//�����λֵ
    	boolean isOverflow = false;
    	
    	for(int i=arr.length-1; i>=0; i--){
    		int nSum = arr[i] +carry;
    		//ÿ��addOneʱ����ִ��һ�μ�һ
    		if(i == arr.length-1){
    			nSum++;
    		}
    		//��ʱҪ��λ��
    		if(nSum >= 10){
    			//���iΪ0��Ҳ���������λҪ������λ����ô�������
    			if(i == 0){
    				isOverflow = true;
    			} else{
    				nSum -= 10;
    				carry = 1;
    				arr[i] = nSum;
    			}
    		}
    		//����λʱ,nSum����,����ѭ��
    		else{
    			arr[i] = nSum;
    			break;
    		}
    	}
    	
    	return isOverflow;
    }
    
	public static void main(String[] args){
		print1ToNthRec(3);
		print1ToNth(2);
	}
}
