package math;

public class PrintProbality {
	//每个骰子最大的点数，6
	public static final int MAX_VALUE = 6;
	
	public static void main(String[] args){
		//printProbability(3);
		printProbability2(3);
	}
	public static void printProbability(int num){
		if(num<1){
			return;
		}
		
		int maxSum = num*MAX_VALUE;
		
		int[] probabilities = new int[maxSum-(num-1)];
		
		probability(num, probabilities);
		
		//所有排列数
		double total = Math.pow(MAX_VALUE, num);
		
		for(int i=num; i<maxSum;i++){
			double ratio = probabilities[i-num]/total;
			System.out.println(ratio);
		}
		
		
	}
	
	public static void probability(int num, int[] probabilities){
		for(int i=1; i<=MAX_VALUE;i++){
			probability(num,num,i,probabilities);
		}
	}
	public static void probability(int origin,int current,int sum, int[] probabilities){
		if(current==1){
			probabilities[sum-origin]++;
		}
		else{
			for(int i=1; i<=MAX_VALUE; i++){
				probability(origin, current-1, sum+i, probabilities);
			}
		}
	}
	
	public static void printProbability2(int num){
		if(num<1){
			return;
		}
		
		int[][] pro = new int[2][MAX_VALUE*num + 1];
		
		int flag = 0;
		
		for(int i=1; i<=MAX_VALUE; i++){
			pro[0][i] = 1;
		}
		
		for(int k=2; k<=num;k++){
			
			for(int i=k;i<MAX_VALUE*num;i++){
				
				for(int j=1;j<=i&&j<=MAX_VALUE;j++){
					pro[1-flag][i] += pro[flag][i-j];
				}
			}
			
			flag = 1 - flag;
		}
		
		//所有排列数
		double total = Math.pow(MAX_VALUE, num);
		
		for(int i=num; i<MAX_VALUE*num;i++){
			double ratio = pro[flag][i]/total;
			System.out.println(ratio);
		}
	}
}
