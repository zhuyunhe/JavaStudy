package easy;

class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int x){
		val = x;
		next = null;
	}
}

public class IntersectionOfLinkedLists {
	
	/**
	 *  双指针法 ，指针pa、pb分别指向链表A和B的首节点。遍历链表A，记录其长度lengthA，遍历链表B，记录其长度lengthB。
	 *  因为两个链表的长度可能不相同，比如题目所给的case，lengthA=5，lengthB=6，则作差得到 lengthB- lengthA=1，
	 *  将指针pb从链表B的首节点开始走1步，即指向了第二个节点，pa指向链表A首节点，然后它们同时走，每次都走一步，当它们相等时，就是交集的节点。 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA!=null && headB!=null){
			ListNode a = headA;
			ListNode b = headB;
			int sizeA = 0;
			int sizeB = 0;
			
			while(a!=null){
				a = a.next;
				sizeA++;
			}
			while(b!=null){
				b = b.next;
				sizeB++;
			}
			if(sizeA >= sizeB){
				int n = sizeA-sizeB;
				a=headA;
				b=headB;
				while(n>0){
					a=a.next;
					n--;
				}
			}
			if(sizeB >= sizeA){
				int n = sizeB-sizeA;
				a=headA;
				b=headB;
				while(n>0){
					b=b.next;
					n--;
				}
			}
			while(a!=b){
				a = a.next;
				b = b.next;
				
				if(a==null || b==null){
					return null;
				}
			}
				return a;
		} else{
			return null;
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
		n3.next = n6;
		
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		ListNode intersectionNode = getIntersectionNode(n1, n6);
		if(intersectionNode != null){
			System.out.println(intersectionNode.val);
		} else{
			System.out.println("no");
		}
		
		
		
	}
}
