package tree;

public class BinaryTree {
	
	int val;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int n){
		this.val = n;
		this.left = null;
		this.right = null;
	}

	
	/**
	 * ������ĳ���ڵ����һ���ڵ�
	 * @param root
	 * @param n
	 */
	public void insertNode(BinaryTree root,int n){
		if(root != null){
			if(root.val > n){
				if(root.left == null){
					root.left = new BinaryTree(n);
				} else{
					insertNode(root.left,n);
				}
			} else{
				if(root.right == null){
					root.right = new BinaryTree(n);
				} else{
					insertNode(root.right, n);
				}
			}
		}
	}
	
	//���ֱ�����ʽ

	/**
	 * �������,�Խڵ�Ĵ���������������ӽڵ㱻����ǰ����
	 * @param root
	 */
	public void preorder(BinaryTree root){
		if(root != null){
			System.out.print(root.val+",");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	/**
	 * �������,�Խڵ�Ĵ���������������ӽڵ㱻��������
	 * @param root
	 */
	public void postorder(BinaryTree root){
		if(root != null){
			preorder(root.left);
			preorder(root.right);
			System.out.print(root.val+",");
		}
	}

	/**
	 * �������
	 * @param root
	 */
	public void inorder(BinaryTree root){
		if(root != null){
			preorder(root.left);
			System.out.print(root.val+",");
			preorder(root.right);
		}
	}
	
	public static void main(String[] args){
		
		int[] array = {1,2,3,3,2};
		BinaryTree binaryTree = new BinaryTree(array[0]);
		for(int i=1;i<array.length;i++){
			binaryTree.insertNode(binaryTree, array[i]);       //��������в�������
		}
		
		System.out.println("�������");
		binaryTree.preorder(binaryTree);
		System.out.println();
		System.out.println("�������");
		binaryTree.inorder(binaryTree);
		System.out.println();
		System.out.println("�������");
		binaryTree.postorder(binaryTree);
	}
	
}
