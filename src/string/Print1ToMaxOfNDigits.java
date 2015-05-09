package string;

import javax.management.RuntimeErrorException;


public class Print1ToMaxOfNDigits {
	
	/**
	 * 利用递归的全排列
	 * 按顺序打印出1到最大的n位数
	 * @param n 数字的最大位数
	 */
	public static void print1ToNthRec(int n){
		if(n<1){
			throw new RuntimeException("输入错误");
		}
		
		int[] arr = new int[n];
		
		//从数组的第0位开始排列
		print1ToNth(0,arr);
	}
	
	public static void print1ToNth(int n,int[] arr){
		//递归终止条件，当n大于了arr数组的长度时，说明排列已经完成
		if(n >= arr.length){
			printArray(arr);
		} else{
			//从数组的高位开始（数组的高位(最右边那一位)相当于最后结果的低位），把数组的每一位都从0到9排列一遍，就得到了所有的十进制数
			for(int i=0; i<=9; i++){
				arr[n] = i;
				print1ToNth(n+1, arr);
			}
		}
	}
	
	/** 
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。 
     * 
     * @param arr 要输出的数组 
     */  
    public static void printArray(int[] arr) {  
        // 找第一个非0的元素  
        int index = 0;  
        while (index < arr.length && arr[index] == 0) {  
            index++;  
        }  
  
        // 从第一个非0值到开始输出到最后的元素。  
        for (int i = index; i < arr.length; i++) {  
            System.out.print(arr[i]);  
        }  
        // 条件成立说明数组中有非零元素，所以需要换行  
        if (index < arr.length) {  
            System.out.println();  
        }
    }
    
    /**
     * 在数组上模拟数字的加法
     * @param n
     */
    public static void print1ToNth(int n){
    	if(n < 1){
    		throw new RuntimeException("输入错误");
    	}
    	
    	
    	int[] arr = new int[n];
    	
    	for(int i=0; i<arr.length; i++){
    		arr[i] = 0;
    	}
    	
    	//如果最高位没有进位就一直处理
    	while(!addOne(arr)){
    		printArray(arr);
    	}
    }
    
    public static boolean addOne(int[] arr){
    	int carry = 0;		//保存进位值
    	boolean isOverflow = false;
    	
    	for(int i=arr.length-1; i>=0; i--){
    		int nSum = arr[i] +carry;
    		//每次addOne时都会执行一次加一
    		if(i == arr.length-1){
    			nSum++;
    		}
    		//此时要进位了
    		if(nSum >= 10){
    			//如果i为0，也就是在最高位要发生进位，那么就溢出了
    			if(i == 0){
    				isOverflow = true;
    			} else{
    				nSum -= 10;
    				carry = 1;
    				arr[i] = nSum;
    			}
    		}
    		//不进位时,nSum不变,跳出循环
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
