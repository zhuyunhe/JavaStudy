package easy;

public class RemoveStartofList {
	/**
	 * 移除链表中正数第n个节点
	 * 建立一个临时的头节点
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromStart(ListNode head, int n) {
		ListNode tem = new ListNode(0);
		if(head == null){
			return null;
		} else{
			if(n == 1){
				return head.next;
			}
			tem.next = head;
			int count = 0;
			while(tem.next != null){
				count++;
				if(count == n){
					tem.next = tem.next.next;
					break;
				}
				tem = tem.next;
			}
			return head;
			
		}
    }
	
	/**
	 * 改进版算法
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromStart_1(ListNode head, int n) {
		ListNode tem = new ListNode(0);
		ListNode p = tem;
		if(head == null){
			return null;
		} else{
			p.next = head;
			int count = 0;
			while(p.next != null){
				count++;
				if(count == n){
					p.next = p.next.next;
					break;
				}
				p = p.next;
			}
			return tem.next;
			
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
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode node = removeNthFromStart_1(n7,1);
		while(node!= null){
			System.out.print(node.val);
			node = node.next;
		}
	}
}
