package array;

/**
 * 找到数组中的第k小的数，或第k大的数
 * 以上两个方法稍微改写一下就是找到数组中的最小的k个数或最大的k个数
 * 这种方法的限制就是会修改输入的数组
 * @author zhu
 *
 */
public class FindKthMin {
	/**
	 * 把一个数组以index为界分为左右两部分，index左边的数小于index，index右边的数大于index
	 * @param a
	 * @param left
	 * @param right
	 * @return index
	 */
	public static int partition(int[] a, int left, int right){
		if(left > right){
			return 0;
		}
		
		int povit = a[left];
		int low = left;
		int high = right;
		
		while(low < high){
			while(low<high && a[high]>povit){
				high--;
			}
			if(low<high){
				a[low] = a[high];
			}
			
			while(low<high && a[low]<=povit){
				low++;
			}
			if(low<high){
				a[high] = a[low];
			}
		}
		
		a[low] = povit;
		
		return low;
	}
	
	/**
	 * 把一个数组以index为界分为左右两部分，index左边的数大于index，index右边的数小于index
	 * @param a
	 * @param left
	 * @param right
	 * @return index
	 */
	public static int partition2(int[] a ,int left, int right){
		if(left > right){
			return 0;
		}
		
		int povit = a[right];
		int low = left;
		int high = right;
		
		while(low <high){
			while(low<high && a[low]>povit){
				low++;
			}
			if(low<high){
				a[high] = a[low];
			}
			
			while(low<high && a[high]<=povit){
				high--;
			}
			if(low<high){
				a[low] = a[high];
			}
		}
		
		a[low] = povit;
		
		return low;
	}
	
	/**
	 * 找到数组中第k小的数
	 * @param a
	 * @param k
	 * @return
	 */
	public static int findKthMin(int[] a,int k){
		if(a == null){
			return 0;
		}
		
		int index = partition(a,0,a.length-1);
		int start = 0;
		int end = a.length-1;
		
		//当index+1==k时，递归退出
		while(index+1 != k){
			if(index+1>k){
				end = index-1;
				index = partition(a, start, end);
			} else{
				start = index+1;
				index = partition(a, start, end);
			}
		}
		
		int result = a[index];
		return result;
	}
	
	public static int findKthMax(int[] a, int k){
		if(a == null){
			return 0;
		}
		int index = partition2(a, 0, a.length-1);
		int start = 0;
		int end = a.length-1;
		
		while(index+1 != k){
			if(index+1 > k){
				end = index-1;
				index = partition2(a, start, end);
			} else{
				start = index+1;
				index = partition2(a, start, end);
			}
		}
		int result = a[index];
		
		return result;
	}
	
	public static void main(String[] args){
		int[] a = {4,3,2,1,5,7,10,1,15,13};
		//System.out.println(findKthMin(a, 4));
		System.out.println(findKthMax(a, 3));
	}
}
