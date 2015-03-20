package tree;


/**
 * 二叉树节点
 * @author zhu
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}

public class BinaryTreeDepth {
	
	public static int depth(TreeNode root){
		
		//先判断根节点是否为null
		if(root == null){
			return 0;
		}
		
		int left = 0;
		if(root.left != null){
			left = 1;
			left += depth(root.left);
			
		}
		
		int right = 0;
		if(root.right != null){
			right = 1;
			right += depth(root.right);
			
		}
		
		return Math.max(left, right);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		
		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(4);
		
		TreeNode node6 = new TreeNode(5);

		
		root.left = left;
		root.right = right;
		left.left = left2;
		left2.right = node6;
		
		System.out.println(depth(root));
	}
}
