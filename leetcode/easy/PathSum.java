package easy;

public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		if(root.val==sum && root.left==null && root.right==null){
			return true;
		}
		
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
	
	
	public static void main(String[] args){
		TreeNode root1 = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		root1.left = left1;
		root1.right = right1;
		if(hasPathSum(root1,5)){
			System.out.println("ok");
		};
	}
}