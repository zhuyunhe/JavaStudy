import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Random1000 {
	public static void main(String[] args) {

		  List<Integer> samples = new ArrayList<Integer>();
		  for (int i = 0; i < 1000; i++)
		  samples.add(i + 1);

		  
		  Random rnd = new Random();
		  for (int i = 0; i < 900; i++){
			  int result = samples.remove(rnd.nextInt(1000 - i));
			  if(i!=899){
			  System.out.print(result+",");
			  }else{
				  System.out.print(result);
			  }
			  

		  }
		 }
}
