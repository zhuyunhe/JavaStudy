package array;

/**
 * 统计一个数字在排序数组中出现的次数
 * @author rttd
 *
 */
public class GetNumOfK {
	public static void main(String[] args){
		int[] a = {1,2,3,3,3,3,3,5,6,8,9,10};
		int first = getFirstK(a, 3);
		int last = getLastK(a, 3);
		System.out.println("3在数组中一共出现了"+(last-first+1)+"次");
		
		int first2 = getFirstKRec(a, 3,0,a.length-1);
		int last2 = getLastKRec(a, 3, 0, a.length-1);
		System.out.println("3在数组中一共出现了"+(last2-first2+1)+"次");
	}
	
	/**
	 * 迭代的二分法查找排序数组中某个数第一次出现的位置
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
			
			//如果middle正好等于des，判断是不是数组中的第一个des
			if(des == a[middle]){
				
				//middle正好是数组中第一个des
				if(middle>0&&a[middle-1]!=des || middle==0){
					return middle;
				} else{
					end = middle-1;
				}
			} else if(des > a[middle]){	//des > a[middle]说明数组中第一个des出现在middle的右边
				start = middle+1;
			} else{	//des < a[middle]说明数组中第一个des出现在middle的左边
				end = middle-1;
			}
		}
		
		return -1;
	}
	
	/**
	 * 递归的二分法查找排序数组中某个数第一次出现的位置
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
		//如果middle正好等于des，判断是不是数组中的第一个des
		if(a[middle] == des){
			//如果middle正好是数组中第一个des的位置，直接返回middle
			if(middle>0&&a[middle-1]!=des || middle==0){
				return middle;
			} else{	//说明des第一次在数组中出现的位置在middle左边
				end = middle-1;
			}
		} else if(a[middle] < des){	//a[middle] < des说明des第一次在数组中出现的位置在middle右边
			start = middle + 1;
		} else{	//a[middle]>des说明des第一次在数组中出现的位置在middle的左边
			end = middle - 1;
		}
		
		//递归调用
		return getFirstKRec(a, des, start, end);
	}
	/**
	 * 迭代的二分法查找排序数组中某个数最后一次出现的位置
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
			//如果middle正好等于des，判断是不是数组中的最后一个des
			if(des == a[middle]){
				//如果middle正好是数组中最后一个des的位置，直接返回middle
				if(a[middle+1]!=des&&middle<a.length-1 || middle==a.length-1){
					return middle;
				} else{
					start = middle+1;
				}
			} else if(des > a[middle]){	//des > a[middle]说明des在数组中最后出现的位置在middle的右边
				start = middle+1;
			}else{	//des < a[middle]说明des在数组中最后出现的位置在middle的左边
				end = middle - 1;
			}
		}
		
		return -1;
	}
	/**
	 * 递归的二分法查找排序数组中某个数最后一次出现的位置
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
		//如果middle正好等于des，判断是不是数组中的最后一个des
		if(a[middle] == des){
			//如果middle正好是数组中最后一个des的位置，直接返回middle
			if(middle<a.length-1&&a[middle+1]!=des || middle==a.length-1){
				return middle;
			} else{	//说明des最后一次在数组中出现的位置在middle右边
				start = middle+1;
			}
		} else if(a[middle] < des){	//a[middle] < des说明des第最后一次在数组中出现的位置在middle右边
			start = middle + 1;
		} else{	//a[middle]>des说明des最后一次在数组中出现的位置在middle的左边
			end = middle - 1;
		}
		
		//递归调用
		return getLastKRec(a, des, start, end);
	}
}
