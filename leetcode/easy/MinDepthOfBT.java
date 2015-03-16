package easy;

public class MinDepthOfBT {
	public static int minDepth(TreeNode root) {
		if(root == null){
			return 0;
		} else{
			if(root.left==null && root.right!=null){
				return minDepth(root.right)+1;
			}
			if(root.left!=null && root.right==null){
				return minDepth(root.left)+1;
			}
			if(root.left==null && root.right==null){
				return 1;
			}
			/*if(root.left == null || root.right == null)
	            return 1 + (root.left == null ? minDepth(root.right) : minDepth(root.left));*/
			//如果两棵子树都不为null
			return 1+Math.min(minDepth(root.left), minDepth(root.right));
			
		}
        
    }
	public static int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		} else{
			if(root.left==null && root.right!=null){
				return maxDepth(root.right)+1;
			}
			if(root.left!=null && root.right==null){
				return maxDepth(root.left)+1;
			}
			if(root.left==null && root.right==null){
				return 1;
			}
			//如果两棵子树都不为null
			return 1+Math.max(minDepth(root.left), minDepth(root.right));
			
		}
		
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		
		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(2);
		
		/*root.left = left;
		root.right = right;
		left.left = left2;
		right.right = right2;*/
		
		System.out.println(minDepth(root));
	}
}
