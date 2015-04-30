package string;

import java.util.ArrayList;
import java.util.Iterator;

public class Print1ToMaxOfNDigits {
	public static void print(int n){
		if(n<0){
			return;
		}
		//用list来表示n，list[0]表示n的最低位
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			list.add(0);
		}
		increament(list);
	}
	
	public static void increament(ArrayList<Integer> list){
		boolean isOverflow = false;
		//进位标志
		int carrybit = 0;
		
		while(!isOverflow){
			for(int i=list.size()-1;i>=0;i--){
				int digit = (int) list.get(i);
				int sum = digit + carrybit;
				if(i==(list.size()-1)){
					sum += 1;
				}
				if(sum >= 10){
					if(i == 0){
						isOverflow = true;
					}
					sum -= 10;
					carrybit = 1;
				} else{
					carrybit = 0;
				}
				list.set(i, sum);
				output(list);
			}
		}
	}
	
	public static void output(ArrayList<Integer> list){
		Iterator<Integer> ite = list.iterator();
		
		//找到第一个为0的位置
		boolean first0 = false;
		
		int num;
		while(ite.hasNext()){
			if(first0){
				 System.out.print(ite.next());
	             continue;
			}
			if ((num = ite.next()) != 0) {
				first0 = true;
                System.out.print(num);
            }
        }
        System.out.println();
	}
	
	
	public static void main(String[] args){
		print(3);
	}
}
