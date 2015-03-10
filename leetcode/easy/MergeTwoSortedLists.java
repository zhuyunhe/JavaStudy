package easy;
public class MergeTwoSortedLists {
	/**
	 * 建一个只有一个头节点的链接，然后把两个要合并的链表按序加入，最后删除头节点
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		
		//建立一个头节点
		ListNode head = new ListNode(1);
		ListNode p = head;
		if(l1 == null){
			p.next = l2;
		}
		
		if(l2 == null){
			p.next = l1;
		}
		
		while(p1!=null & p2!=null){
			if(p1.val <= p2.val){
				p.next = p1;
				p1 = p1.next;
			}else{
				p.next = p2;
				p2 = p2.next;
			}
			
			p = p.next;
			
		}
		
		if(p1 != null){
			p.next = p1;
		}
		if(p2 != null){
			p.next = p2;
		}
		
		return head.next;
    }
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		n1.next = n2;
		n2.next = n6;
		
		n4.next = n6;
		n6.next = n7;
		
		ListNode intersectionNode = mergeTwoLists(n1, n4);
		while(intersectionNode.next != null){
			System.out.print(intersectionNode.val);
			intersectionNode = intersectionNode.next;
		}
		
		
		
	}
}
