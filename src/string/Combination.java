package string;

    import java.util.LinkedList;

/**
 * ���ַ����������
 * @author zhu
 *
 */
public class Combination {
	/**
	 * ����1
	 * @param c ԭ�ַ�����
	 * @param index ��ǰ������ַ���c�е�λ��
	 * @param count ��ǰ������ַ��ĸ���
	 * @param maxCount Ҫ���������ַ��ĸ���
	 * @param result ������Ͻ����list
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
		//��Ҫ��result�е��ַ�������Ҫ�������е��ַ���ʱ����ӡ�������
		if(count == maxCount){
			System.out.println(result);
			return;
		}
		
		//��ʼʱi=index<c.lengthҲ�ǵݹ��˳�����
		//��i=c.lengthʱ����ִ�������forѭ�����ݹ�Ҳ����Ȼ�˳�
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
