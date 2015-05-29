package array;

/**
 * 美团面试
 * @author zhu
 *
 */
public class MX {
	public static void main(String[] args){
		int[][] a ={{1,2,3,1},
					{4,11,6,3},
					{9,8,12,2},
					{20,25,1,7}
					};
		int max = 0;
		
		try {
			max = findMax(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(max);
	}
	
	public static int findMax(int[][] a) throws Exception{
		if(a == null){
			throw new Exception("输入存储");
		}
		int ny = a.length;
		int nx = a[0].length;
		if(nx != ny || nx<3){
			throw new Exception("输入存储");
		}
		
		int n = ny;
		
		int max = Integer.MIN_VALUE;
		int x = Integer.MIN_VALUE;
		int y= Integer.MIN_VALUE;
		int diagonal = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(j+2<n){
					x = a[i][j] + a[i][j+1] + a[i][j+2];
				}
				
				if(i+2<n){
					y = a[i][j] + a[i+1][j] + a[i+2][j];
				}
				
				if(i+2<n && j+2<n){
					diagonal = a[i][j] + a[i+1][j+1] + a[i+2][j+2];
				}
				int temp = maxOfthree(x, y, diagonal);
				if(temp>max){
					max = temp;
				}
			}
		}
		return max;
	}
	
	public static int maxOfthree(int a, int b, int c){
		int max = a;
		if(a < b){
			max = b;
		}
		
		if(c>max){
			max = c;
		}
		
		return max;
	}
}
