package tree;

public class HasSubTree {
	/**
	 * 判断tree2是否为tree1的子树
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static boolean hasSubTree(TreeNode tree1,TreeNode tree2){
		boolean result = false;
		
		if(tree1!=null && tree2!=null){
			//如果在tree1中找到和tree2的根节点的值一样的节点R
			if(tree1.val == tree2.val){
				//判断tree1中以R为好、根节点的子树和tree2是不是一样有相同结构
				result = doesTree1HasTree2(tree1, tree2);
			}
			//接着递归遍历tree1寻找和tree2的根节点值一样的节点R
			if(!result){
				result = hasSubTree(tree1.left, tree2);
			}
			if(!result){
				result = hasSubTree(tree1.right, tree2);
			}
		}
		
		return result;
	}
	
	public static boolean doesTree1HasTree2(TreeNode tree1,TreeNode tree2){
		//如果tree2为null，返回true
		//注意，这个判断条件要放在前面，不能和后面那个tree1的颠倒位置
		if(tree2 == null){
			return true;

		}
		//tree2!=null而tree1==null，说明tree2肯定不是tree1的一部分，返回false
		if(tree1 == null){
			return false;
		}
		if(tree1.val != tree2.val){
			return false;
		}
		
		//如果根节点值相同，递归判断tree1和tree2的左子树和右子树的结点值
		return doesTree1HasTree2(tree1.left, tree2.left) && doesTree1HasTree2(tree1.right, tree2.right);
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
		
		TreeNode tree2 = new TreeNode(5);
		TreeNode left3 = new TreeNode(3);
		TreeNode right3 = new TreeNode(8);
		
		tree2.left = left3;
		tree2.right = right3;
		
		if(hasSubTree(tree1, tree2)){
			System.out.println("ok");
		} else{
			System.out.println("nonono");
		}
		
	}
}
