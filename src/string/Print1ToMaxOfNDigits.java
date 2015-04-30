package string;

import java.util.ArrayList;
import java.util.Iterator;

public class Print1ToMaxOfNDigits {
	public static void print(int n){
		if(n<0){
			return;
		}
		//��list����ʾn��list[0]��ʾn�����λ
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			list.add(0);
		}
		increament(list);
	}
	
	public static void increament(ArrayList<Integer> list){
		boolean isOverflow = false;
		//��λ��־
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
		
		//�ҵ���һ��Ϊ0��λ��
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
