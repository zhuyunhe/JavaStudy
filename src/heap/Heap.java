package heap;

/**
 * 二叉堆的性质：
 * 父结点的值总是大于等于（或小于等于）子节点的值
 * 每个结点的左子树和右子树都是一个二叉堆
 * @author zhu
 *
 */
public class Heap {
	/**
	 * 上虑，用于堆增加
	 * @param a
	 * @param i 新加入结点的数组下标
	 */
	public static void minHeapFixup(int[] a, int i){
		int j,temp;
		temp = a[i];
		
		//找到父节点
		j = (i-1)/2;
		
		while(j>=0&&i!=0){
			//如果父节点小于要插入的结点，那不用做调整，跳出循环
			if(a[j] <= temp){ 
				break;
			}
			//把父节点的值放到数组中下标为i的位置，并更新i和j
			a[i] = a[j];
			i = j;
			j = (i-1)/2;
		}
		
		a[i] = temp;
	}
	
	public static void minHeapAddNumber(int[] a,int n, int nNum){
		a[n] = nNum;
		minHeapFixup(a,n);
	}
	
	/**
	 * 最小堆下虑，用于堆删除
	 * 堆中每次删除只能删除第0个数据,也就是堆得根节点元素
	 * 删除根后在根处形成了一个空穴，我们要将空穴的两个儿子的较小者移入空穴
	 * 这样就把空穴向下推了一层，重复该步直到堆得最后一个元素可以放入空穴中
	 * @param a
	 * @param i
	 * @param n
	 */
	public static void minHeapFixdown(int a[],int i,int n){
		int j,temp;
		
		temp = a[i];
		j = 2*i + 1;
		while(j<n){
			//在左右孩子中找最小的
			if(j+1<n && a[j+1]<a[j]){
				j++;
			}
			
			if(a[j]>=temp){
				break;
			}
			
			//把较小的子节点往上移动，替换它的父节点
			a[i] = a[j];
			i=j;
			j=2*i+1;
		}
		
		a[i] = temp;
		
	}
	
	/**
	 * 最大堆的下虑，按《数据结构与算法分析》第190页写法
	 * @param a
	 * @param i
	 * @param n
	 */
	public static void maxHeapFixdown(int[] a,int i,int n){
		int child;
		int temp;
		
		for(temp=a[i];leftChild(i)<n;i=child){
			child = leftChild(i);
			
			//找出左右子节点中较大的
			if(child!=n-1 && a[child]<a[child+1]){
				child++;
			}
			
			//父节点与较大的节点比较
			//如果父节点小于它较大的子节点，那么子节点上移替换父节点
			if(temp<a[child]){
				a[i] = a[child];
			} else{ //如果父节点大于其子节点，那不做变化
				break;
			}
		}
		
		//把temp元素放到最后那个被交换的元素的位置上
		a[i] = temp;
	}
	
	/**
	 * 最大堆下虑内部使用的函数
	 * @param i
	 * @return
	 */
	public static int leftChild(int i){
		return 2*i+1;
	}
	
	/**
	 * 删除堆元素
	 * @param a
	 * @param n
	 */
	public static void minHeapDeleteNumber(int a[],int n){
		swapReference(a,0,n-1);
		minHeapFixdown(a, 0, n-1);
	}
                       
	/**
	 * 交换数组中两个位置上元素的值
	 * @param a 目标数组
	 * @param i
	 * @param j
	 */
	public static void swapReference(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * 建立最小堆
	 * @param a
	 * @param n
	 */
	public static void makeMinHeap(int a[],int n){
		for(int i=n/2-1;i>=0;i--){
			minHeapFixdown(a, i, n);
		}
	}
	
	/**
	 * 建立最大堆
	 * @param a
	 * @param n
	 */
	public static void makeMaxHeap(int[] a,int n){
		for(int i=n/2-1;i>=0;i--){
			maxHeapFixdown(a, i, n);
		}
	}
	
	/**
	 * 利用最小堆排序
	 * @param a
	 * @param n
	 */
	public static void minHeapSort(int[] a,int n){
		//建立最小堆
		makeMinHeap(a, a.length);
		
		for(int i=n-1; i>=1; i--){
			//deleteMin,把最小堆的根节点，也就是最小的元素放到数组最后
			swapReference(a,0,i);
			
			//其余元素重新恢复最大堆
			minHeapFixdown(a, 0, i);
		}
	}
	
	public static void maxHeapSort(int[] a,int n){
		//建立最大堆
		makeMaxHeap(a, a.length);
		
		for(int i=n-1; i>=1; i--){
			//deleteMax,把最大堆的根节点，也就是最大的元素放到数组最后
			swapReference(a,0,i);
			
			//其余元素重新恢复最大堆
			maxHeapFixdown(a, 0, i);
		}
	}
	
	//测试
	public static void main(String[] args){
		int[] a = {34,8,64,51,32,21};
		
		//利用最小堆排序
		minHeapSort(a, a.length);
		for(int i : a){
			System.out.print(i+",");
		}
		
		System.out.println();
		
		//利用最大堆排序
		maxHeapSort(a, a.length);
		for(int i : a){
			System.out.print(i+",");
		}
		
	}
}
