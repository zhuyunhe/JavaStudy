package tree;

public class ConverTreeToList {
	public static TreeNode convert(TreeNode root){
		
		//指向链表中最后一个元素，开始时链表为空
		TreeNode lastNode = null;
		
		
		//整个过程其实可以看作是是往一个空链表中追加元素的过程
		lastNode = convertNode(root, lastNode);
		
		TreeNode head = lastNode;
		while(head!=null && head.left!=null){
			head = head.left;
		}
		
		return head;
	}
	
	/**
	 * 整个递归是一个中序遍历过程
	 * 按照中序遍历的顺序，遍历到某个根节点时，其左子树已经是一个排好序的链表了,然后去递归处理右子树
	 * @param root 当前要处理的节点
	 * @param lastNode 链表中的最后一个节点
	 * @return
	 */
	public static TreeNode convertNode(TreeNode root,TreeNode lastNode){
		if(root==null){
			return null;
		}
		
		//得到当前节点
		TreeNode currentNode = root;
		
		//如果当前节点的左子树存在，那么将其左子树转换成一个排好序的双向链表，并且把该链表的最后一个元素返回
		if(currentNode.left!=null){
			lastNode = convertNode(currentNode.left,lastNode);
		}

		/* 中序遍历的“中”部分*/
		//把当前节点加入排好序的双向链表中去，完成后，当前节点就成了这个排好序的链表的最后一个节点
		currentNode.left = lastNode;
		if(lastNode != null){
			lastNode.right = currentNode;
		}
		
		lastNode = currentNode;
		/* ******end***** */
		
		//如果当前节点的右子树存在，那么把右子树加入到上面排好序的双向链表中去
		if(currentNode.right!=null){
			lastNode = convertNode(currentNode.right,lastNode);
		}
		return lastNode;
	}
	
	public static void main(String[] args){
		TreeNode tree1 = new TreeNode(5);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(7);
		
		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(4);
		
		tree1.left = left;
		tree1.right = right;
		left.left = left2;
		left.right = right2;
		
		TreeNode list = convert(tree1);
		
		while(list!=null){
			System.out.println(list.val);
			list = list.right;
		}
	}
}
