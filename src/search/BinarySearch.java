package search;

public class BinarySearch {
	/**
	 * 迭代实现二分查找
	 * 二分查找又称折半查找，它是一种效率较高的查找方法。 
	 * 【二分查找要求】：1.必须采用顺序存储结构 2.必须按关键字大小有序排列。
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
	 * 递归实现二分查找
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
	 * 迭代二分查找数组中第一个des的位置
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
			//如果中间数字和des相等
			if(des == a[middle]){
				//判断这个中间数是不是第一个des
				//如果这个中间数的前一个数不等于des，那说明第一个des就是中间这数
				if(middle>0&&a[middle -1] != des || middle == 0){
					return middle;
					
				} else{ //如果这个中间数的前一个数等于des，那说明第一个des在数组的前半部分
					high = middle - 1;
				}
			}
			//如果中间数大于des，des只可能出现在数组的前半段
			else if(a[middle] > des){
				high = middle - 1;
			} else{
				low = middle + 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * 递归二分查找数组中第一个des的位置
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
	 * 递归二分查找数组中最后一个des的位置
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
	 * 迭代二分查找数组中最后一个des的位置
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
				//判断这个中间数是不是最后一个des
				//如果这个中间数的后一个数不等于des，那说明最后一个des就是中间这数
				if(middle<a.length-1&&a[middle+1]!=des || middle==a.length-1){
					return middle;
				} else{ //如果这个中间数的后一个数等于des，那说明最后一个des在数组的后半部分
					low = middle+1;
				}
			}
			//如果这个中间数小于des，说明最后一个des在数组后半部分
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
		//二分查找
		System.out.println(binarySearch(a, 3));
		System.out.println(binarySearchRec(a, 3, 0, a.length-1));
		
		//二分查找des第一次出现的位置
		System.out.println(binarySearchFirstPos(a, 3));
		System.out.println(binarySearchFirstPosRec(a, 3, 0, a.length-1));
		
		//二分查找des最后一次出现的位置
		System.out.println(binarySearchLastPos(a, 3));
		System.out.println(binarySearchLastPosRec(a, 3, 0, a.length-1));
		int count = binarySearchLastPosRec(a, 3, 0, a.length-1)-binarySearchFirstPos(a, 3)+1;
		System.out.println("offer38题");
		System.out.println("数组中共有"+count+"个3");
	}
	
}
