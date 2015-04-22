package list;

public class ReverseList {
	
	/**
	 * �ݹ�˼��
	 * �ڷ�ת��ǰ�ڵ�֮ǰ������ýڵ��к����ڵ㣬�ȷ�ת������ڵ�
	 * ����ýڵ�û���ӽڵ㣬�ͰѸýڵ��nextָ���丸�ڵ㣬�������ڵ��next��Ϊnull
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
	 * ������˫ָ��һǰһ��ͬʱ��β���ƶ�
	 * @param head
	 * @return
	 */
	public static ListNode reverse1(ListNode head){
		if(head==null){
			return head;
		}
		ListNode pre = head; //ǰһ��ָ��
		ListNode cur = head.getNext();  //��һ��ָ��
		ListNode next;
		while(cur != null){
			next = cur.getNext();
			cur.setNext(pre);
			pre = cur; //ָ���ƶ�
			cur = next;
		}
		
		//һ���ǵð�head��next��Ϊnull
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
