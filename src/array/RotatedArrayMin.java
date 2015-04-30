package array;

public class RotatedArrayMin {
	/**
	 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
	 * @param a
	 * @param length
	 * @return
	 * @throws Exception 
	 */
	public static int min(int[] a, int length) throws Exception{
		if(a==null || length<=0){
			throw new Exception("range can't be negative or zero.");
		}
		
		int index1=0;
		int index2=length-1;
		int indexMid = index1;
		
		while(a[index1] >= a[index2]){
			if(index2-index1 == 1){
				indexMid = index2;
				break;
			}
			
			indexMid = (index1+index2)/2;
			
			//如果下标为index1，index2和indexMid的元素相等，只能顺序查找
			if(a[index1] == a[index2] && a[index1] == a[indexMid]){
				findMin(a);
			}
			
			//中间元素大于index1元素，说明中间元素在第一个递增数组中，并且最小的数位于它后面
			if(a[indexMid] >= a[index1]){
				index1 = indexMid;
			} //中间元素小于index2元素，说明中间元素在第二个递增数组中，并且最小的数位于它前面或者就是它自己
			else if(a[indexMid] <= a[index2]){
				index2 = indexMid;
			}
		}
		return a[indexMid];
	}
	
	//顺序查找数组中最小的数
	public static int findMin(int[] a){
		int min=a[0];
		for(int i=0; i<a.length; i++){
			if(a[i]<min){
				min = a[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) throws Exception{
		int[] a ={0,1,2,3};
		
		System.out.println(min(a,a.length));
		System.out.println(findMin(a));
	}
}
