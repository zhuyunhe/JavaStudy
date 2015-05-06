package stack;

import java.util.Stack;

public class IsPopOrder {
	/**
	 * ���������������У���һ�����б�ʾջ��ѹ��˳���жϵڶ��������Ƿ�ջ�ĵ�������
	 * �����������У������һ��Ҫ��������������λ��ջ������ôջֱ�ӵ���ջ��Ԫ�أ�
	 * �����һ��Ҫ������������ջ��Ԫ�أ���ô����ջ�����е�Ԫ��������ջ��ֱ��Ҫ��һ��Ҫ������Ԫ����ջΪֹ
	 * @param push ��ջ˳��
	 * @param pop  ��ջ˳��
	 * @return
	 */
	public static boolean isPoporder(int[] push, int[] pop){
		boolean result = false;
		
		int popNext = 0;
		int pushNext = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(popNext < pop.length){
			
			//ջΪ��ʱ��ֱ�Ӱ���ջ���е�Ԫ��ѹ��
			while(stack.isEmpty() || stack.peek()!= pop[popNext]){
				
				//pushNext���ܳ���push����ķ�Χ
				if(pushNext == push.length){
					break;
				}
				stack.push(push[pushNext]);
				pushNext++;
			}
			
			//���������ջ���е�Ԫ�ض���ջ�˻���û�ҵ���һ��Ҫ���������֣�˵���������в���
			if(stack.peek()!=pop[popNext]){
				break;
			}
			
			//ջ��Ԫ�ظպ�����һ��Ҫ���������֣���ֱ�ӵ�������������һ��Ҫ���������ֵ��±�
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
