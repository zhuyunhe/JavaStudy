package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class KeyNum{
	int val;
	KeyNum rightNext;
	KeyNum downNext;
	
	public KeyNum(int n,KeyNum r,KeyNum d){
		this.val = n;
		this.rightNext = r;
		this.downNext = d;
	}
}

public class NumericKeypad {
	public static void main(String[] args){
		int[] arr = {25,83,131};
		int n = arr.length;
		
		KeyNum k0 = new KeyNum(0,null,null);
		KeyNum k9 = new KeyNum(9,null,null);
		KeyNum k8 = new KeyNum(8,k9,k0);
		KeyNum k7 = new KeyNum(7,k8,null);
		KeyNum k6 = new KeyNum(6,null,k9);
		KeyNum k5 = new KeyNum(5,k6,k8);
		KeyNum k4 = new KeyNum(4,k5,k7);
		KeyNum k3 = new KeyNum(3,null,k6);
		KeyNum k2 = new KeyNum(2,k3,k5);
		KeyNum k1 = new KeyNum(1,k2,k4);

		LinkedList<KeyNum> keyNumList = new LinkedList<KeyNum>();
		keyNumList.add(k0);
		keyNumList.add(k1);
		keyNumList.add(k2);
		keyNumList.add(k3);
		keyNumList.add(k4);
		keyNumList.add(k5);
		keyNumList.add(k6);
		keyNumList.add(k7);
		keyNumList.add(k8);
		keyNumList.add(k9);
		
		for(int i=0; i<n; i++){
			List<Integer> list = splitInt(arr[i]);
			LinkedList<KeyNum> resultKeyNumList = null;
			int p1 = 0;
			int p2 = 0;
			for(int j=0; j<list.size()-1; j++){
				p1 = list.get(j);
				p2 = list.get(j+1);
				//顺序正确
				resultKeyNumList = check(keyNumList,p1,p2);
			}
			
			List<Integer> result = new LinkedList<Integer>();
			for(int k=0; k<resultKeyNumList.size(); k++){
				result.add(resultKeyNumList.get(k).val);
			}
			
			System.out.println(result);
			
		}
	}
	
	public static LinkedList<KeyNum> check(LinkedList<KeyNum> keyNumList ,int p1,int p2){
		LinkedList<KeyNum> list = new LinkedList<KeyNum>();
		for(int i=0;i<keyNumList.size();i++){
			if(p1 == keyNumList.get(i).val){
				KeyNum temp = keyNumList.get(i).rightNext;
				//要判断temp是否为null
				if(keyNumList.get(i).rightNext != null){
					int right = keyNumList.get(i).rightNext.val;
					if(p2 == right){
						list.add(keyNumList.get(i));
						list.add(keyNumList.get(i).rightNext);
						break;
					}
				}
				
				if(keyNumList.get(i).downNext != null){
					int down = keyNumList.get(i).downNext.val;
					if(p2 == down){
						list.add(keyNumList.get(i));
						list.add(keyNumList.get(i).downNext);
						break;
					}
				}
				{
					//动态调整
					if(p1 < p2){
						//p2 = p2 -1;
						list = check(keyNumList ,p1+1,p2);
						break;
					} else{ //p1>p2
						//如果p1不等于3，6，9
						if(p2==3 || p2==6 || p2==9){
							p2=0;
							list.add(keyNumList.get(i));
							list.add(new KeyNum(0,null,null));
						} else{
							p1 = p1 -1;
							KeyNum max = findMax(keyNumList.get(i));
							list.add(keyNumList.get(i));
							list.add(max);
						}
						break;
					}
				}
			}
		}
		return list;
	}
	
	public static KeyNum findMax(KeyNum k){
		//先往最右边找
		while(k.rightNext != null){
			k = k.rightNext;
		}
		while(k.downNext != null){
			k = k.downNext;
		}
		return k;
	}
	
	public static List<Integer> splitInt(int n){
		List<Integer> list = new ArrayList<Integer>();
		while(n>0){
			list.add(n%10);
			n /= 10;
		}
		return reverseList(list);
	}
	
	/**
	 * 倒置一个list的顺序
	 * @param list
	 * @return
	 */
	public static List<Integer> reverseList(List<Integer> list){
		int size =list.size();
		int medium = size/2;
		int last = size - 1;
		
		for(int i=0; i<medium; i++){
			int tem = list.get(i);
			list.set(i, list.get(last-i));
			list.set(last-i, tem);
		}
		
		return list;
	}
}
