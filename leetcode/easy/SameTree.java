package easy;

public class SameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
        	return p==null&q==null;
        } else{
        	return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
	
	public static void main(String[] args){
		TreeNode root1 = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		TreeNode root2 = new TreeNode(1);
		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(3);
		root1.left = left1;
		root1.right = right1;
		
		root2.left = left2;
		root2.right = right2;
		if(isSameTree(root1, root2)){
			System.out.println("ok");
		}
	}
}
