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
	 *  ˫ָ�뷨 ��ָ��pa��pb�ֱ�ָ������A��B���׽ڵ㡣��������A����¼�䳤��lengthA����������B����¼�䳤��lengthB��
	 *  ��Ϊ��������ĳ��ȿ��ܲ���ͬ��������Ŀ������case��lengthA=5��lengthB=6��������õ� lengthB- lengthA=1��
	 *  ��ָ��pb������B���׽ڵ㿪ʼ��1������ָ���˵ڶ����ڵ㣬paָ������A�׽ڵ㣬Ȼ������ͬʱ�ߣ�ÿ�ζ���һ�������������ʱ�����ǽ����Ľڵ㡣 
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
