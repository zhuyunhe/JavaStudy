package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> a = new ArrayList<List<Integer>>();
		for(int i=0; i<numRows; i++){
			if(i == 0){
				a.add(new ArrayList<Integer>());
				a.get(i).add(1);
			} else{
				a.add(new ArrayList<Integer>());
				int size = a.get(i-1).size();
				for(int j=0; j<=size; j++){
					//判断是否是边缘
					if(j==0 || j==size){
						//三角形边缘都是1
						a.get(i).add(1);
					}else{
						a.get(i).add(a.get(i-1).get(j-1)+a.get(i-1).get(j));
					}
				}
			}
		}
		return a;
        
    }
	
	public static void main(String[] args){
		List<List<Integer>> list = generate(5);
		System.out.println(list);
	}
}
