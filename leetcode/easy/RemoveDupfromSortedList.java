package easy;

public class RemoveDupfromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head != null){
			
		ListNode p1 = head;
		ListNode p2 = head;
		
		p2 = p2.next;
		while(p2!=null){
			if(p1.val != p2.val){
				p1 = p2;
				p2 = p2.next;
			} else{
				p2 = p2.next;
				p1.next = p2;
			}
			
		}	
		return head;
		} else{
			return null;
		}
    }
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode node = deleteDuplicates(n7);
		while(node!= null){
			System.out.print(node.val);
			node = node.next;
		}
	}
}
