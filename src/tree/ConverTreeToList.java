package tree;

public class ConverTreeToList {
	public static TreeNode convert(TreeNode root){
		
		//ָ�����������һ��Ԫ�أ���ʼʱ����Ϊ��
		TreeNode lastNode = null;
		
		
		//����������ʵ���Կ���������һ����������׷��Ԫ�صĹ���
		lastNode = convertNode(root, lastNode);
		
		TreeNode head = lastNode;
		while(head!=null && head.left!=null){
			head = head.left;
		}
		
		return head;
	}
	
	/**
	 * �����ݹ���һ�������������
	 * �������������˳�򣬱�����ĳ�����ڵ�ʱ�����������Ѿ���һ���ź����������,Ȼ��ȥ�ݹ鴦��������
	 * @param root ��ǰҪ����Ľڵ�
	 * @param lastNode �����е����һ���ڵ�
	 * @return
	 */
	public static TreeNode convertNode(TreeNode root,TreeNode lastNode){
		if(root==null){
			return null;
		}
		
		//�õ���ǰ�ڵ�
		TreeNode currentNode = root;
		
		//�����ǰ�ڵ�����������ڣ���ô����������ת����һ���ź����˫���������ҰѸ���������һ��Ԫ�ط���
		if(currentNode.left!=null){
			lastNode = convertNode(currentNode.left,lastNode);
		}

		/* ��������ġ��С�����*/
		//�ѵ�ǰ�ڵ�����ź����˫��������ȥ����ɺ󣬵�ǰ�ڵ�ͳ�������ź������������һ���ڵ�
		currentNode.left = lastNode;
		if(lastNode != null){
			lastNode.right = currentNode;
		}
		
		lastNode = currentNode;
		/* ******end***** */
		
		//�����ǰ�ڵ�����������ڣ���ô�����������뵽�����ź����˫��������ȥ
		if(currentNode.right!=null){
			lastNode = convertNode(currentNode.right,lastNode);
		}
		return lastNode;
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
		
		TreeNode list = convert(tree1);
		
		while(list!=null){
			System.out.println(list.val);
			list = list.right;
		}
	}
}
