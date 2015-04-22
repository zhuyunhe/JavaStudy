package sort;

/**
 * 在插入第i个数，第0到第（i-1）个数已经排好序
 * 初始时默认第一个数自己有序
 * @author zhu
 *
 */
public class InsertSort {
    public static void insertSort1(int a[], int n)  
    {  
        int i, j, k;  
        for (i = 1; i < n; i++)  
        {  
            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置  
            for (j = i - 1; j >= 0; j--)  
                if (a[j] < a[i])  
                    break;  
      
            //如找到了一个合适的位置  
            if (j != i - 1)  
            {  
                //将比a[i]大的数据向后移  
                int temp = a[i];  
                for (k = i - 1; k > j; k--)  
                    a[k + 1] = a[k];  
                //将a[i]放到正确位置上  
                a[k + 1] = temp;  
            }  
        }  
    }
    
    public static void insertSort2(int a[], int n)  
    {  
        int i, j;  
        for (i = 1; i < n; i++)  
        {  
        	//a[i]<a[i-1]时才需要调整
            if(a[i]<a[i-1]){
            	int temp = a[i];
            	//a[j]>temp这个条件别忘了
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
