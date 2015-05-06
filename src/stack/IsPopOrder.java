package stack;

import java.util.Stack;

public class IsPopOrder {
	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否栈的弹出序列
	 * 遍历弹出序列，如果下一个要弹出的数字正好位于栈顶，那么栈直接弹出栈顶元素；
	 * 如果先一个要弹出的数不是栈顶元素，那么把入栈序列中的元素依次入栈，直到要下一个要弹出的元素入栈为止
	 * @param push 入栈顺序
	 * @param pop  出栈顺序
	 * @return
	 */
	public static boolean isPoporder(int[] push, int[] pop){
		boolean result = false;
		
		int popNext = 0;
		int pushNext = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(popNext < pop.length){
			
			//栈为空时，直接把入栈序列的元素压入
			while(stack.isEmpty() || stack.peek()!= pop[popNext]){
				
				//pushNext不能超出push数组的范围
				if(pushNext == push.length){
					break;
				}
				stack.push(push[pushNext]);
				pushNext++;
			}
			
			//如果所有入栈序列的元素都入栈了还是没找到下一个要弹出的数字，说明弹出序列不对
			if(stack.peek()!=pop[popNext]){
				break;
			}
			
			//栈顶元素刚好是下一个要弹出的数字，那直接弹出，并更新下一个要弹出的数字的下标
			stack.pop();
			popNext++;
			
		}
		
		if(stack.isEmpty() || popNext==pop.length){
			result = true;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int[] push = {1,2,3,4,5};
		int[] pop = {5,4,3,2,2};
		
		if(isPoporder(push, pop)){
			System.out.println("ok");
		} else{
			System.out.println("nonono");
		}
	}
}
