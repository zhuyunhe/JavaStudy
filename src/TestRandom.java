import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TestRandom {
	public static void main(String[] args) {

		  List<Integer> samples = new ArrayList<Integer>();
		  for (int i = 0; i < 100; i++)
		   samples.add(i + 1);

		  Random rnd = new Random();
		  for (int i = 0; i < 99; i++)
		   System.out.print(samples.remove(rnd.nextInt(100 - i)) + " ");
		  System.out.print("The one is " + samples.get(0));
		 }
}
