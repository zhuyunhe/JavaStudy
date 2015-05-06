package tree;

public class HasSubTree {
	/**
	 * �ж�tree2�Ƿ�Ϊtree1������
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static boolean hasSubTree(TreeNode tree1,TreeNode tree2){
		boolean result = false;
		
		if(tree1!=null && tree2!=null){
			//�����tree1���ҵ���tree2�ĸ��ڵ��ֵһ���Ľڵ�R
			if(tree1.val == tree2.val){
				//�ж�tree1����RΪ�á����ڵ��������tree2�ǲ���һ������ͬ�ṹ
				result = doesTree1HasTree2(tree1, tree2);
			}
			//���ŵݹ����tree1Ѱ�Һ�tree2�ĸ��ڵ�ֵһ���Ľڵ�R
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
		//���tree2Ϊnull������true
		//ע�⣬����ж�����Ҫ����ǰ�棬���ܺͺ����Ǹ�tree1�ĵߵ�λ��
		if(tree2 == null){
			return true;

		}
		//tree2!=null��tree1==null��˵��tree2�϶�����tree1��һ���֣�����false
		if(tree1 == null){
			return false;
		}
		if(tree1.val != tree2.val){
			return false;
		}
		
		//������ڵ�ֵ��ͬ���ݹ��ж�tree1��tree2�����������������Ľ��ֵ
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
