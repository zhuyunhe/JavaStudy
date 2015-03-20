package medium;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}
public class SortedListToBT {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null; //�ýڵ����ڴ��м�ն������
		
		//ѭ������ҵ�������м�ڵ�
		//��ʱfastָ������β���ڵ㣬slowָ���м�ڵ�
		while(fast.next != null){
			fast = fast.next;
			if(fast.next == null){
				break;
			}
			fast = fast.next;
			prev = slow;
			slow = slow.next;
			
		}
		if(prev!=null){
			prev.next=null;
		} else{
			head = null;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
        
    }
}
