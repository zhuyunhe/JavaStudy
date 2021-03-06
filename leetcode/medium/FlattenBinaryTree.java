package medium;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}
public class FlattenBinaryTree {
	private TreeNode fNode = new TreeNode(0);
	public void flatten(TreeNode root) {
		if(root == null){
			return;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		flatten(left);
		flatten(right);
		
		root.right = left;
		
		TreeNode tem = root;
		
		while(tem.right!=null){
			tem = tem.right;
		}
		
		tem.right = right;
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
		
		FlattenBinaryTree ft = new FlattenBinaryTree();
		ft.flatten(root);
	}
}
