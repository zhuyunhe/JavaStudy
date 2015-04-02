package medium;


public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		if(head == null){
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		
		while(current.next!=null && current.next.next!=null){
			ListNode first = current.next;
			ListNode second = current.next.next;
			
			first.next = second.next;
			second.next = first;
			
			current.next = second;
			current.next.next = first;
			
			current = current.next.next;
			
		}
		
		
        return dummy.next;
    }
	
	/**
	 * 递归
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs1(ListNode head) {
		if(head == null || head.next==null){
			return head;
		}
		
		//temp存着已经交换完顺序的节点
		ListNode temp = swapPairs1(head.next.next);
		
		ListNode second = head.next;
		second.next = head;
		head.next = temp;
		
        return second;
    }
	
	
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		node1 = swapPairs1(node1);
		
		while(node1 != null){
			System.out.print(node1.val+" ");
			node1 = node1.next;
		}
	}
}
