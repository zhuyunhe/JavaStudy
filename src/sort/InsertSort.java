package sort;

/**
 * �ڲ����i��������0���ڣ�i-1�������Ѿ��ź���
 * ��ʼʱĬ�ϵ�һ�����Լ�����
 * @author zhu
 *
 */
public class InsertSort {
    public static void insertSort1(int a[], int n)  
    {  
        int i, j, k;  
        for (i = 1; i < n; i++)  
        {  
            //Ϊa[i]��ǰ���a[0...i-1]������������һ�����ʵ�λ��  
            for (j = i - 1; j >= 0; j--)  
                if (a[j] < a[i])  
                    break;  
      
            //���ҵ���һ�����ʵ�λ��  
            if (j != i - 1)  
            {  
                //����a[i]������������  
                int temp = a[i];  
                for (k = i - 1; k > j; k--)  
                    a[k + 1] = a[k];  
                //��a[i]�ŵ���ȷλ����  
                a[k + 1] = temp;  
            }  
        }  
    }
    
    public static void insertSort2(int a[], int n)  
    {  
        int i, j;  
        for (i = 1; i < n; i++)  
        {  
        	//a[i]<a[i-1]ʱ����Ҫ����
            if(a[i]<a[i-1]){
            	int temp = a[i];
            	//a[j]>temp�������������
            	for(j=i-1;j>0&&a[j]>temp;j--){
            		a[j+1] = a[j];
            	}
            	a[j+1] = temp;
            }
        }  
    }
    
    public static void insertSort3(int[] a,int n){
    	for(int i=1; i<n; i++){
    		int temp = a[i];
    		for(int j=i-1; j>0&&a[j]>temp; j--){
    			a[j+1] = a[j];
    			a[j] = temp;
    		}
    	}
    }
    
    public static void main(String[] args){
    	int[] a = {0,3,2,1};
    	insertSort3(a,a.length);
    	for(int n : a){
    		System.out.println(n);
    	}
    }
}
