package sort;

/**
 * 希尔排序，又叫分组插入排序，缩小增量排序。
 * 先将整个待排元素序列分割成若干个子序列（由相隔某个增量的元素组成），分别进行插入排序
 * 然后依次缩减增量再进行排序，待整个序列中的元素基本有序时，再对全体元素进行一次直接插入排序
 * @author zhu
 *
 */
public class ShellSort {
	public static void shellSort(int[] a,int n){
		
		for(int gap=n/2; gap>0; gap/=2){
			for(int i=0; i<gap; i++){
				//开始在子序列中进行插入排序
				for(int j=i+gap; j<n; j+=gap){
					if(a[j] < a[j-gap]){
						int temp = a[j];
						//注意这的条件
						for(int k=j-gap;k>=0&&a[k]>temp;k-=gap){
							a[k+gap] = a[k];
							a[k] = temp;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args){
    	int[] a = {4,3,2,1};
    	shellSort(a,a.length);
    	for(int n : a){
    		System.out.println(n);
    	}
    }
}
