package list;

public class ReverseList {
	
	/**
	 * 递归思想
	 * 在翻转当前节点之前，如果该节点有后续节点，先翻转其后续节点
	 * 如果该节点没有子节点，就把该节点的next指向其父节点，并不父节点的next置为null
	 * @param head
	 * @return
	 */
	public static ListNode reverse(ListNode head){
		if(head==null || head.getNext()==null){
			return head;
		}
		
		ListNode tempNode = reverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		
		return tempNode;
	}
	
	/**
	 * 遍历，双指针一前一后同时向尾部移动
	 * @param head
	 * @return
	 */
	public static ListNode reverse1(ListNode head){
		if(head==null){
			return head;
		}
		ListNode pre = head; //前一个指针
		ListNode cur = head.getNext();  //后一个指针
		ListNode next;
		while(cur != null){
			next = cur.getNext();
			cur.setNext(pre);
			pre = cur; //指针移动
			cur = next;
		}
		
		//一定记得把head的next置为null
		head.setNext(null);
		head = pre;
		return head;
		
	}
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		node1 = reverse1(node1);
		
		while(node1 != null){
			System.out.print(node1.getVal()+" ");
			node1 = node1.getNext();
		}
	}
}
