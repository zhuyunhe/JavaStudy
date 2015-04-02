package list;

public class ListNode {
	private int val;
	private ListNode next;
	
	public ListNode(int value){
		this.val = value;
		this.next = null;
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}
