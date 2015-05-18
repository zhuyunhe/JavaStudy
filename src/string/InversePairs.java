package string;

public class InversePairs {
	public static void main(String[] args){
		int[] a ={7,6,5,4};
		int[] temp = new int[a.length];
		
		for(int i=0; i<a.length; i++){
			temp[i] = a[i];
		}
		System.out.println(inversePairs2(a,temp,0,a.length-1));
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
		
		int left = inversePairs(temp, a, start, middle);
		int right = inversePairs(temp, a, middle+1, end);
		
		//i初始化为前半段数组的最后一个元素下标
		int i = middle;
		
		//j初始化为后半段数组的最后一个元素的下标
		int j = end;
		
		int indexCopy = end;
		
		//记录逆序对数
		int count = 0;
		
		while(i>=start && j>=middle+1){
			if(a[i] > a[j]){
				temp[indexCopy--] = a[i--];
				count += j-(middle);
			} else{
				temp[indexCopy--] = a[j--];
			}
		}
		
		while(i>=start){
			temp[indexCopy--] = a[i--];
		}
		while(j>=middle+1){
			temp[indexCopy--] = a[j--];
		}
		
		return count+left+right;
	}
	
	public static int inversePairs2(int[] a,int[] temp,int start,int end){
		if(start<end){
			int middle = (start+end)/2;
			int left = inversePairs2(a,temp,start,middle);
			int right = inversePairs2(a,temp,middle+1,end);
			
			int count = merge(a,temp,start,middle,end);
			
			return left+right+count;
		}else{
			return 0;
		}
	}
	
	public static int merge(int[] a,int[] temp, int start,int middle,int end){
		int i = middle;
		
		int j = end;
		
		int index = end;
		
		int count = 0;
		while(i>=start && j>=middle+1){
			if(a[i] > a[j]){
				temp[index--] = a[i--];
				//这是关键
				count += j - (middle);
			} else{
				temp[index--] = a[j--];
			}
		}
		while(i>=start){
			temp[index--] = a[i--];
		}
		while(j>=middle+1){
			temp[index--] = a[j--];
		}
		
		//把临时数组排好序的部分拷贝回原始数组
		for(int k=end; k>index; k--){
			a[k] = temp[k];
		}
		return count;
	}
}
