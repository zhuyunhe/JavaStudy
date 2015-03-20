package easy;

public class BalancedBinaryTree {
	private boolean result = true;
	
	public boolean isBalanced(TreeNode root) {
		depth(root);
		return result;
    }
	
	public int depth(TreeNode root){
		
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
		
		if(Math.abs(left-right)>1){
			result = false;
		}
		
		return Math.max(left, right);
	}
	
	/**
	 * 精简的求二叉树高度的算法
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
	    if (root == null)
	        return 0;
	    int l = maxDepth(root.left);
	    int r = maxDepth(root.right);
	    if (Math.abs(l - r) > 1)
	        result = false;
	    return 1 + Math.max(l, r);
	}
	
	public static void main(String[] args){
		BalancedBinaryTree tree = new BalancedBinaryTree();
		TreeNode root = new TreeNode(1);
		
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		
		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(4);
		
		TreeNode node6 = new TreeNode(5);

		
		root.left = left;
		root.right = right;
		left.left = left2;
		left2.left = node6;
		
		if(tree.isBalanced(root)){
			System.out.println("ok");
		} else{
			System.out.println("no");
		}
		
	}
	
}
