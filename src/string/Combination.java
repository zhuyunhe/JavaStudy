package string;

    import java.util.LinkedList;

/**
 * 求字符的所有组合
 * @author zhu
 *
 */
public class Combination {
	/**
	 * 方法1
	 * @param c 原字符数组
	 * @param index 当前处理的字符在c中的位置
	 * @param count 当前组合中字符的个数
	 * @param maxCount 要求的组合中字符的个数
	 * @param result 保存组合结果的list
	 */
	public static void combination(char[] c, int index, int count, int maxCount, LinkedList<Character> result){
		if(count == maxCount){
			System.out.println(result);
			return;
		}
		
		for(int i=index; i<c.length; i++){
			result.addLast(c[i]);
			combination(c,i+1, count+1, maxCount, result);
			result.removeLast();
		}
	}
	
	public static void combination(char[] c,int index,int count, int maxCount,String result){
		//当要求result中的字符数满足要求的组合中的字符数时，打印出该组合
		if(count == maxCount){
			System.out.println(result);
			return;
		}
		
		//初始时i=index<c.length也是递归退出条件
		//当i=c.length时，不执行下面的for循环，递归也就自然退出
		for(int i=index; i<c.length; i++){
			combination(c, i+1, count+1, maxCount, result+c[i]+" ");
		}
	}
	
	public static void main(String[] args){
		String result = "";
		char[] c = {'a','b','c'};
		combination(c, 0, 0, 2, result);
		
		System.out.println("-------------");
		
		LinkedList<Character> result2 = new LinkedList<Character>();
		combination(c, 0, 0, 3, result2);
	}
}
