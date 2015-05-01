package list;

public class FindKthToTail {
	/**
	 * 两个指针，一个先走k-1步
	 * @param root
	 * @param k
	 * @return
	 */
	public static ListNode findKthTotail(ListNode root,int k){
		if(root==null || k<=0){
			return null;
		}
		
		ListNode ahead = root;
		ListNode behind = root;
		
		for(int i=0; i<k-1; i++){
			if(ahead.getNext() != null){
				ahead = ahead.getNext();
			} else{
				return null;
			}
		}
		
		while(ahead.getNext() != null){
			ahead = ahead.getNext();
			behind = behind.getNext();
		}
		
		return behind;
		
	}
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		//打印出倒数第二个结点的值
		System.out.println(findKthTotail(node1, 2).getVal());
		
		node5.setNext(node6);
		
	}
}
