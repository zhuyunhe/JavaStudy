package list;

public class MergeList {
	/**
	 * 递归合并两个排序的链表,并且去除链表中值重复的结点
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static ListNode mergeRec(ListNode root1, ListNode root2){
		if(root1 == null){
			return root2;
		} else if(root2 == null){
			return root1;
		}
		ListNode mergeNode = null;

		if(root1.getVal() < root2.getVal()){
			mergeNode = root1;
			mergeNode.setNext(mergeRec(root1.getNext(), root2));
		} else if(root1.getVal() > root2.getVal()){
			mergeNode = root2;
			mergeNode.setNext(mergeRec(root1, root2.getNext()));
		} else{
			mergeNode = root2;
			mergeNode.setNext(mergeRec(root1.getNext(), root2.getNext()));
		}
		
		return mergeNode;
	}
	
	/**
	 * 迭代合并两个排序的链表
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static ListNode merge(ListNode root1,ListNode root2){
		if(root1 == null){
			return root2;
		} else if(root2 == null){
			return root1;
		}
		
		ListNode mergeNode = new ListNode(0);
		ListNode p = mergeNode;
		ListNode p1 = root1;
		ListNode p2 = root2;

		while(p1!=null && p2!=null){
			if(p1.getVal() < p2.getVal()){
				p.setNext(p1);
				p = p.getNext();
				p1 = p1.getNext();
			} else{
				p.setNext(p2);
				p = p.getNext();
				p2 = p2.getNext();
			}
		}
		
		while(p1!=null){
			p.setNext(p1);
			p = p.getNext();
			p1 = p1.getNext();
		}
		
		while(p2!=null){
			p.setNext(p2);
			p = p.getNext();
			p2 = p2.getNext();
		}
		
		
		return mergeNode.getNext();
	}
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		node5.setNext(node6);
		
		ListNode mergeNode = mergeRec(node1, node5);
		
		while(mergeNode != null){
			System.out.print(mergeNode.getVal()+" ");
			mergeNode = mergeNode.getNext();
		}
	}
}
