package array;

public class PrintMatrixClock {
	public static void printMatrixClock(int[][] a){
		if(a==null){
			return;
		}
		
		int columns = a[0].length;	//����
		int rows = a.length;		//����
		int start = 0;
		
		while(columns>start*2 && rows>start*2){
			pringtMatrixInClock(a,columns,rows,start);
			start++;
		}
	}
	
	public static void pringtMatrixInClock(int[][] a,int columns, int rows,int start){
		int endX = columns - start -1;
		int endY = rows - start - 1;
		//�����Ҵ�ӡһ��
		for(int i=start; i<=endX; i++){
			System.out.print(a[start][i]+"-");
		}
		
		//���ϵ��´�ӡһ��
		if(start<endY){
		for(int i=start+1; i<=endY; i++){
			System.out.print(a[i][endX]+"-");
		}
		}
		
		if(start<endX && start<endY){
		//���ҵ����ӡһ��
		for(int i=endX-1; i>=start; i--){
			System.out.print(a[endY][i]+"-");
		}
		}
		
		if(start<endX && start<endY-1){
		//���µ��ϴ�ӡһ��
		for(int i=endY-1; i>=start+1; i--){
			System.out.print(a[i][start]+"-");
		}
		}
	}
	
	public static void main(String[] args){
		int[][] a ={
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15},
		};
		printMatrixClock(a);
	}
}
