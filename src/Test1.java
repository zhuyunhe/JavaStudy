public class Test1{
    public static void main(String args[]){
            String a="1234";
            String b="1234";
            String c = new String("1234");
            System.out.println(a==b);
            System.out.println(a==c);
            System.out.println(a.equals(c));
            int[] arr = {1,3,7,9,9,5,4,3,6,1,7};
            find(arr,arr.length);
    }
    
    /**
     * �õ�num�Ķ��������е�һ��Ϊ1��λ��λ�õĺ���
     * @param num
     * @return ����������1���ֵ����λ��λ��
     */
    public static int getFirstOnePos(int num){
    	int pos = 1;
    	//�ҵ�num�Ķ��������е�һ��Ϊ1��λ��λ��
    	while((num&0x01)==0){
    		num = num>>1;
    		pos++;
    	}
    	return pos;
    }
    
    /**
     * ��������ĺ���
     * �����posλΪ1����ô����true��
     * @param num Ҫ���з������
     * @param pos λ��
     * @return
     */
    public static boolean divide(int num,int pos){
    	num = num>>(pos-1);
    	return (num&0x01)==1?true:false;
    }
    
    /**
     * ���ҳ�����������ֻ���ֹ�һ�ε���
     * @param a Ҫ���ҵ�����
     * @param n ���鳤��
     */
    public static void find(int[] a,int n){
    		int num1 = 0;
    		int num2 = 0;
          	int povit = 0;
          	//0���������ÿһ��Ԫ�أ��õ�������ֻ���ֹ�һ�ε�Ԫ�ص����ֵ
          	for(int i=0;i<n;i++){
          		povit ^= a[i];
          	}
          	
          	//�ҵ�a^b�Ķ����Ʊ�ʾ�е�һ��Ϊ1��λ��
          	int pos = getFirstOnePos(povit);
          	
          	for(int i=0; i<n; i++){
          		//����
          		//��һ����posλΪ1��
          		if(divide(a[i],pos)){
          			//��������������Ψһ���ֹ�һ����
          			num1 ^= a[i];
          		} else{ //�ڶ�����posλΪ0��
          			num2 ^= a[i];
          		}
          	}
          	System.out.println(num1);
          	System.out.println(num2);
          	
    }
}