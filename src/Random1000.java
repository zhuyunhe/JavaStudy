import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class Random1000 {
	public static void main(String[] args) {

		  List<Integer> samples = new ArrayList<Integer>();
		  for (int i = 0; i < 1000; i++)
		  samples.add(i + 1);

		  
		  Random rnd = new Random();
		  for (int i = 0; i < 100; i++){
			  int result = samples.remove(rnd.nextInt(1000 - i));
			  if(i!=899){
			  System.out.print(result+",");
			  }else{
				  System.out.print(result);
			  }
		  }
		  System.out.println();
		  System.out.println(samples.size());
		  System.out.println(rnd.nextInt(5));
		  System.out.println(10%3);
		  
		  HashSet<Integer> set = new HashSet<Integer>();
		  ran(set, 10, 3);
		  System.out.println(set);
		 }
	/*
	 * 从n个样本中随机找出k个
	 */
	public static void ran(HashSet<Integer> set,int n,int k){
		Random rnd = new Random();
		for(int i=1; i<=n; i++){
			if(i-set.size() <= (n-k+1)){
				set.add(i);
			} else if(rnd.nextInt(n) < k-1){
				set.add(i);
			}
		}
	}
}
