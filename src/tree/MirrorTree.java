package tree;

public class MirrorTree {
	/**
	 * �ݹ���������ľ���,�ı���ԭ������
	 * ������������������Ƿ�Ҷ�ӽ�㣬�������������ӽ�㡣
	 * @param tree
	 * @return
	 */
	public static TreeNode mirrorRec(TreeNode tree){
		if(tree == null){
			return null;
		}
		//�����������������Ϊnull��ֻ��һ�����ڵ㣩��ֱ�ӷ��ظ��ڵ�
		if(tree.left==null && tree.right==null){
			return tree;
		}
		
		//������Ҷ�ӽ��������ֽ�λ��
		TreeNode tempNode = tree.left;
		tree.left = tree.right;
		tree.right = tempNode;
		
		//�ݹ�������
		if(tree.left!=null){
			tree.left = mirrorRec(tree.left);
		}
		//�ݹ�������
		if(tree.right!=null){
			tree.right=mirrorRec(tree.right);
		}
		
		return tree;
	}
	
	/**
	 * �ݹ���������ľ���,���ı�ԭ��������һ���µ���
	 * ������������������Ƿ�Ҷ�ӽ�㣬�������������ӽ�㡣
	 * @param tree
	 * @return
	 */
	public static TreeNode mirrorRec2(TreeNode tree){
		TreeNode newTree = null;
		if(tree == null){
			return newTree;
		}
		//�����������������Ϊnull��ֻ��һ�����ڵ㣩��ֱ�ӷ��ظ��ڵ�
		if(tree.left==null && tree.right==null){
			newTree = tree;
			return newTree;
		}
		
		//������Ҷ�ӽ��������ֽ�λ��
		newTree = new TreeNode(tree.val);
		newTree.left = tree.right;
		newTree.right = tree.left;
		
		//�ݹ�������
		if(tree.left!=null){
			newTree.left = mirrorRec(tree.right);
		}
		//�ݹ�������
		if(tree.right!=null){
			newTree.right=mirrorRec(tree.left);
		}
		
		return newTree;
	}
	
	/**
	 * �ж����ö������Ƿ�Ϊ����
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
