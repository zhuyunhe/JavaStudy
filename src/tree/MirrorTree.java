package tree;

public class MirrorTree {
	/**
	 * 递归求二叉树的镜像,改变了原来的树
	 * 先序遍历这棵树，如果是非叶子结点，交换它的左右子结点。
	 * @param tree
	 * @return
	 */
	public static TreeNode mirrorRec(TreeNode tree){
		if(tree == null){
			return null;
		}
		//如果该树左右子树都为null（只有一个根节点），直接返回根节点
		if(tree.left==null && tree.right==null){
			return tree;
		}
		
		//交换根叶子结点的两个字节位置
		TreeNode tempNode = tree.left;
		tree.left = tree.right;
		tree.right = tempNode;
		
		//递归左子树
		if(tree.left!=null){
			tree.left = mirrorRec(tree.left);
		}
		//递归右子树
		if(tree.right!=null){
			tree.right=mirrorRec(tree.right);
		}
		
		return tree;
	}
	
	/**
	 * 递归求二叉树的镜像,不改变原树，返回一个新的树
	 * 先序遍历这棵树，如果是非叶子结点，交换它的左右子结点。
	 * @param tree
	 * @return
	 */
	public static TreeNode mirrorRec2(TreeNode tree){
		TreeNode newTree = null;
		if(tree == null){
			return newTree;
		}
		//如果该树左右子树都为null（只有一个根节点），直接返回根节点
		if(tree.left==null && tree.right==null){
			newTree = tree;
			return newTree;
		}
		
		//交换根叶子结点的两个字节位置
		newTree = new TreeNode(tree.val);
		newTree.left = tree.right;
		newTree.right = tree.left;
		
		//递归左子树
		if(tree.left!=null){
			newTree.left = mirrorRec(tree.right);
		}
		//递归右子树
		if(tree.right!=null){
			newTree.right=mirrorRec(tree.left);
		}
		
		return newTree;
	}
	
	/**
	 * 判断两棵二叉树是否互为镜像
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static boolean isMirror(TreeNode tree1,TreeNode tree2){
		boolean result = false;
		if(tree1==null && tree2==null){
			return true;
		}
		
		if(tree1!=null &&tree2!=null){
			if(tree1.val == tree2.val){
				result = true;
			}
			result = isMirror(tree1.left,tree2.right);
			result = isMirror(tree1.right,tree2.left);
		}

		return result;
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
		
		TreeNode tree2;
		
		
		BinaryTreeDepth.preOrderRec(tree1);
		System.out.println();
		tree2 = mirrorRec2(tree1);
		BinaryTreeDepth.preOrderRec(tree2);
		System.out.println();
		if(isMirror(tree1, tree2)){
			System.out.println("ok");
		} else{
			System.out.println("nonono");
		}
	}
}
