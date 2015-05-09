package list;

import java.net.ConnectException;

/**
 * ��ָoffer26��
 * @author rttd
 *
 */
public class CloneComplexList {
	
	public static  ComplexListNode clone(ComplexListNode head){
		cloneNodes(head);
		connectSiblingNodes(head);
		return reconnectNodes(head);
	}
	
	
	public static void cloneNodes(ComplexListNode head){
		ComplexListNode pNode = head;
		
		while(pNode!=null){
			ComplexListNode clonedNode = new ComplexListNode();
			clonedNode.val = pNode.val;
			clonedNode.next = pNode.next;
			clonedNode.sibling = null;
			
			pNode.next = clonedNode;
			
			pNode = clonedNode.next;
		}
	}
	
	public static void connectSiblingNodes(ComplexListNode head){
		ComplexListNode pNode = head;
		
		while(pNode != null){
			ComplexListNode clonedNode = pNode.next;
			if(pNode.sibling!=null){
				//���Ҫע�⣬�״�
				clonedNode.sibling = pNode.sibling.next;
			}
			
			//���ǧ������if���һ�ξʹ�����
			pNode = clonedNode.next;
		}
	}
	
	/**
	 * �ѳ������ֳ�������������λ�õĵ�����������ԭʼ����ż��λ�����������Ǹ��Ƴ���������
	 */
	public static ComplexListNode reconnectNodes(ComplexListNode head){
		ComplexListNode pNode = head;
		ComplexListNode clonedHead = null;
		ComplexListNode clonedNode = null;
		
		if(pNode!=null){
			clonedHead = head.next;
			clonedNode = clonedHead;
			
			pNode.next = clonedNode.next;
			pNode = pNode.next;
		}
		
		while(pNode!=null){
			clonedNode.next = pNode.next;
			clonedNode = clonedNode.next;
			
			pNode.next = clonedNode.next;
			pNode = pNode.next;
		}
		
		return clonedHead;
	}
	
	public static void main(String[] args){
		ComplexListNode node1 = new ComplexListNode(1);
		ComplexListNode node2 = new ComplexListNode(2);
		ComplexListNode node3 = new ComplexListNode(3);
		ComplexListNode node4 = new ComplexListNode(4);
		ComplexListNode node5 = new ComplexListNode(5);

		node1.next = node2;
		node2.next = node3;
		//node3.next = node4;
		//node4.next = node5;
		
		node1.sibling = node3;
		//node3.sibling = node5;
		
		ComplexListNode clonedNode =  clone(node1);
		
		while(clonedNode!=null){
			System.out.println(clonedNode.val);
			clonedNode = clonedNode.next;
		}
	}
}
