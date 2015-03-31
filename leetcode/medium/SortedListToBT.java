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
		ListNode prev = null; //该节点用于从中间斩断链表
		
		//循环完后找到链表的中间节点
		//此时fast指向链表尾部节点，slow指向中间节点
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
