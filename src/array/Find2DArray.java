package array;

public class Find2DArray {
	public static boolean find(int[][] a,int row,int col,int n){
		boolean found = false;
		int r = 0;
		int c = col;
		
		while(a!=null && r<row && col>0){
			if(n == a[r][c-1]){
				found = true;
				System.out.println(r+"|"+(c-1));
				break;
			} else if(n < a[r][c-1]){
				c--;
			} else{
				r++;
			}
		}
		return found;
	}
	
	public static void main(String[] args){
		int[][] a ={
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15},
		};
		boolean found = find(a, 4, 4, 7);
		if(found){
			System.out.println("ok");
		}
	}
}
