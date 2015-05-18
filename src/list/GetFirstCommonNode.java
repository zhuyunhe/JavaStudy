package list;

import sun.org.mozilla.javascript.internal.Node;

public class GetFirstCommonNode {
	public static void main(String[] args){
		ListNode list1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode list2 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		list1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		list2.setNext(node6);
		node6.setNext(node3);
		
		ListNode node7 = new ListNode(7);

		
		ListNode commonNode = getFirstCommonNode1(node7, list2);
		if(commonNode!=null){
			System.out.println(commonNode.getVal());
		} else{
			System.out.println("无公共节点");
		}
	}
	
	public static ListNode getFirstCommonNode1(ListNode list1,ListNode list2){
		if(list1==null || list2==null){
			return null;
		}
		
		int length1 = getListLength(list1);
		int length2 = getListLength(list2);
		
		ListNode longList = list2;
		ListNode shortList = list1;
		int dif = length2 - length1;
		
		if(length1 > length2){
			longList = list1;
			shortList = list2;
			dif = length1 - length2;
		}
		
		while(dif>0){
			longList = longList.getNext();
			dif--;
		}
		
		while(longList!=null && shortList!=null && longList!=shortList){
			longList = longList.getNext();
			shortList = shortList.getNext();
		}
		
		return longList;
	}
	
	public static int getListLength(ListNode list){
		int length = 0;
		while(list != null){
			length++;
			list = list.getNext();
		}
		return length;
	}
}
