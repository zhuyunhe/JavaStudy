package easy;

public class RemoveEndofList {
	/**
	 * �Ƴ������е�����n���ڵ�
	 * ˫ָ�룬����ָ����ͬʱָ��ͷ�ڵ�
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		} else{
			ListNode p1 = head;
			ListNode p2 = head;
			
			for(int i=0; i<n; i++){
				p1 = p1.next;
				//Ҳ����˵�������Ĵ�Сǡ�õ���n
				if(p1 == null){
					return head.next;
				}
			}
			
			while(p1.next != null){
				p1 = p1.next;
				p2 = p2.next;
			}
			
			p2.next = p2.next.next;
			return head;
			
		}
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
		
		ListNode node = removeNthFromEnd(n1,2);
		while(node!= null){
			System.out.print(node.val);
			node = node.next;
		}
	}
}
