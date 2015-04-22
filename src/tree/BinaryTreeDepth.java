package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * �������ڵ�
 * @author zhu
 *
 */
class TreeNode implements Comparable<TreeNode>{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
	
	@Override
	public int compareTo(TreeNode o) {
		if(this.val > o.val){
			return 1;
		} else if(this.val < o.val){
			return -1;
		} else{
			return 0;
		}
	}
	
	//��дtoString����,����д�Ļ�����toString������hash��
	@Override
	public String toString(){
		return Integer.toString(this.val);
		
	}
}

public class BinaryTreeDepth {

	
		/*������� 
		 * 
		 * */
	
	public static int depth(TreeNode root){
		
		//���жϸ��ڵ��Ƿ�Ϊnull
		if(root == null){
			return 0;
		}
		
		int left = 0;
		if(root.left != null){
			left = depth(root.left);
			
		}
		
		int right = 0;
		if(root.right != null){
			right = depth(root.right);
			
		}
		
		return Math.max(left, right)+1;
	}
	
	/**
	 * �ݹ�ķ���
	 * @param root
	 * @return
	 */
	public static int depth1(TreeNode root){
		//���жϸ��ڵ��Ƿ�Ϊnull
		if(root == null){
			return 0;
		}
		
		int left = 0;
		if(root.left != null){
			left = depth1(root.left);
		}
		
		int right = 0;
		if(root.right != null){
			right = depth1(root.right);
		}
		
		return Math.max(left, right) +1;
	}
	
	/**
	 * �������������
	 * @param root
	 * @return
	 */
	public static int depthRec(TreeNode root){
		if(root == null){
			return 0;
		}
		int depth = 0;
		//��ǰ������
		int curNodes = 1;
		
		//��һ������
		int nextNodes = 0;
		
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		
		while(!list.isEmpty()){
			TreeNode curNode = list.poll();
			curNodes--;
			
			if(curNode.left!=null){
				list.add(curNode.left);
				nextNodes++;
			}
			
			if(curNode.right!=null){
				list.add(curNode.right);
				nextNodes++;
			}
			
			//curNodes == 0 ��ʾ�ò��ѽ��������+1��ת����һ��
			if(curNodes == 0){
				depth++;
				curNodes = nextNodes;
				nextNodes = 0;	//��һ����������
			}
			
		}
		
		return depth;
	}
	
	/*���ı���
	 * 
	 * */
	
	
	/**
	 * �������������
	 * @param root
	 */
	public static void preOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode curNode = stack.pop();
			System.out.print(curNode.val + "-");
			
			//��ջʱ�����Һ���Ȼ����һ���ĳ�ջ�����������
			if(curNode.right!=null){
				stack.push(curNode.right);
			}
			
			if(curNode.left!=null){
				stack.push(curNode.left);
			}
		}
	}
	
	/**
	 * �ݹ����������
	 * @param root
	 */
	public static void preOrderRec(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.val + "-");
		preOrderRec(root.left);
		preOrderRec(root.right);
	}
	
	/**
	 * �������������
	 * @param root
	 */
	public static void inOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		TreeNode cur = root;
		
		while(true){
			//����ߵĽ����ջ
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			
			if(stack.isEmpty()){
				break;
			}
			
			//�����������
			cur = stack.pop();
			System.out.print(cur.val+"-");
			
			//���������ұ�
			cur = cur.right;
		}
	}
	
	/**
	 * �ݹ����������
	 * @param root
	 */
	public static void inOrderRec(TreeNode root){
		if(root == null){
			return;
		}
		inOrderRec(root.left);
		System.out.print(root.val+"-");
		inOrderRec(root.right);
	}
	
	/**
	 * �������������
	 * @param root
	 */
	public static void postOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		//�����������ջ
		LinkedList<TreeNode> result = new LinkedList<TreeNode>();

		
		TreeNode curNode = null;
		stack.push(root);
		
		while(!stack.isEmpty()){
			curNode = stack.pop();
			
			//�����������-��-�е�˳��
			result.push(curNode);
			
			if(curNode.left != null){
				stack.push(curNode.left);
			}
			if(curNode.right != null){
				stack.push(curNode.right);
			}
		}
		
		while(!result.isEmpty()){
			System.out.print(result.pop().val+"-");
		}
	}
	
	/**
	 * �ݹ�������
	 * @param root
	 */
	public static void postOrderRec(TreeNode root){
		if(root == null){
			return;
		}
		postOrderRec(root.left);
		postOrderRec(root.right);
		System.out.print(root.val+"-");
		
	}
	
	
	/*���Ľ��Ĳ��� 
	 * 
	 * */
	/**
	 * ����һ���ڵ�
	 * @param root ���ڵ�
	 * @param newNode Ҫ����Ľ��
	 * @return
	 */
	public static TreeNode insertNode(TreeNode root,TreeNode newNode){
		if(root == null){
			root = newNode;
		}
		
		//�½���ֵС�ڸ�����ֵ�����뵽��������ȥ
		else if(root.val>newNode.val){
			//���������������ڣ����½�������������
			if(root.left!=null){
				insertNode(root.left,newNode);
			} else{ //��������������ڣ�����½����Ϊ������
				root.left = newNode;
			}
		}//�½���ֵ���ڸ�����ֵ�����뵽��������ȥ
		else if(root.val<newNode.val){
			//���������������ڣ����½�������������
			if(root.right!=null){
				insertNode(root.right,newNode);
			} else{ //��������������ڣ�����½����Ϊ������
				root.right = newNode;
			}
		}
		return root;
	}
	
	/**
	 * 
	 * @param root
	 * @param newNode
	 * @return
	 */
	public static TreeNode insertNode1(TreeNode root,TreeNode newNode){
		if(root == null){
			root = newNode;
		}
		
		int result = root.compareTo(newNode);
		
		if(result > 0){
			root.left = insertNode1(root.left,newNode);
		} else if(result < 0){
			root.right = insertNode1(root.right,newNode);
		} else
			;
		return root;
	}
	
	/*���Ĳ���
	 * 
	 * */
	
	/**
	 * �����������Ķ��ֲ���
	 * ʹ���˵���ѭ����û��ʹ�õݹ�
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode search(TreeNode root,int key){
		if(root == null){
			return null;
		}
		
		//ʹ��ѭ��ʱҪע���ж�root�Ƿ��Ϊnull����Ϊ����������rootһֱ�ڱ�
		while(root!=null && root.val != key){
			if(key<root.val){
				root = root.left;
			} else{
				root = root.right;
			}
		}
		return root;
	}
	
	/**
	 * �����������Ķ��ֲ���
	 * ʹ���˵ݹ�
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode search1(TreeNode root,int key){
		if(root == null){
			return null;
		}
		
		TreeNode result = null;
		
		if(key == root.val){
			result = root;
		} else if(key<root.val){
			result = search1(root.left,key);
		} else{
			result = search1(root.right,key);
		}
		return result;
	}
	
	/**
	 * �ݹ��������һ���м������
	 * @param root
	 * @return
	 */
	public static int getNodeNumRec(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int num = 1;
		return getNodeNumRec(root.left)+getNodeNumRec(root.right)+num;
	}
	
	/**
	 * �����������н����
	 * @param root
	 * @return
	 */
	public static int getNodeNum(TreeNode root){
		if(root == null){
			return 0;
		}
		int num = 0;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.push(root);
		
		while(!list.isEmpty()){
			num++;
			TreeNode curNode = list.pop();
			//push(null)���nullҲ��Ϊһ��Ԫ�ؼӵ�list��ȥ����������Ҫ���ж�
			if(curNode.left!=null){
				list.push(curNode.left);
			}
			if(curNode.right!=null){
				list.push(curNode.right);
			}
		}
		
		return num;
	}
	
	/**
	 * ���������
	 * @param root
	 */
	public static void levelTraversal(TreeNode root){
		if(root == null){
			return;
		}
		
		//�½�һ���б��Ƚ��ȳ���
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode curNode = null;
		while(!queue.isEmpty()){
			//��ȡ���õ�����ͷ
			curNode = queue.poll();
			System.out.print(curNode.val+"-");
			
			if(curNode.left != null){
				queue.add(curNode.left);
			}
			
			if(curNode.right != null){
				queue.add(curNode.right);
			}
		}
	}
	
	/**
	 * ʹ�õݹ������������
	 * @param root
	 */
	public static void levelTraRec(TreeNode root){
		if(root == null){
			return;
		}
		
		//Ƕ������ÿһ����Ϊ��������һ����㣬ÿһ���еĽ���ֵ������һ������
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		
		//�ӵ�0�㿪ʼ
		dfs(root,0,list);
		
		System.out.println(list);
	}
	
	/**
	 * ��������ĵݹ麯��
	 * @param root ��ʼ���
	 * @param level ��������0�㿪ʼ
	 * @param list �����
	 */
	public static void dfs(TreeNode root,int level,ArrayList<LinkedList<TreeNode>> list){
		if(root == null){
			return;
		}
		//list��ʼʱsizeΪ0
		if(level >= list.size()){
			list.add(new LinkedList<TreeNode>());
		}
		
		list.get(level).add(root);
		
		//�ݹ�
		dfs(root.left,level+1,list);
		dfs(root.right,level+1,list);
		
	}
	
	/**
	 * �ݹ����������k���ϵĽ����
	 * @param root
	 * @param k
	 * @return
	 */
	public static int getNodeNumKthLevelRec(TreeNode root,int k){
		if(root==null || k<0){
			return 0;
		}
		
		if(k == 1){
			return 1;
		}
		
		return getNodeNumKthLevelRec(root.left,k-1)+getNodeNumKthLevelRec(root.right,k-1);
		
	}
	
	/**
	 * ���������k���ϵĽ����
	 * ������������Ƶ������������
	 * @param root
	 * @param k
	 * @return
	 */
	public static int getNodeNumKthLevel(TreeNode root,int k){
		if(root==null || k<0){
			return 0;
		}
		int curNodes = 1;	//��ǰ��Ľ����
		int nextNodes = 0;	//��һ������
		TreeNode curNode = root;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		
		list.add(curNode);
		int i = 1;
		
		while(!list.isEmpty() && i<k){
			curNode = list.poll();
			curNodes--;
			
			if(curNode.left != null){
				list.add(curNode.left);
				nextNodes++;
			}
			if(curNode.right != null){
				list.add(curNode.right);
				nextNodes++;
			}
			
			if(curNodes == 0){
				curNodes = nextNodes;
				nextNodes = 0;
				i++;
			}
		}
		return curNodes;
		
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(7);
		
		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(4);
		
		
		//������
		insertNode1(root, left);
		insertNode1(root, left);
		insertNode1(root, right);
		insertNode1(root, left2);
		insertNode1(root, right2);
		/**
		 *           5
		 *          / \
		 *         3   7
		 *        / \
		 *       2   4
		 */

		
		
		System.out.println("�������Ϊ��"+depthRec(root));
		System.out.println("�������Ϊ��"+depth1(root));

		System.out.println("����һ���ж��ٸ���㣺"+getNodeNum(root));
		System.out.println("����һ���ж��ٸ���㣺"+getNodeNumRec(root));
		
		System.out.println("���������");
		preOrder(root);
		System.out.println();
		preOrderRec(root);
		System.out.println();
		
		
		System.out.println("���������");
		inOrder(root);
		System.out.println();
		inOrderRec(root);
		System.out.println();
		
		System.out.println("���������");
		postOrder(root);
		System.out.println();
		postOrderRec(root);
		System.out.println();
		
		
		System.out.println("���������");
		levelTraversal(root);
		System.out.println();
		levelTraRec(root);
		System.out.println();
		
		System.out.println("��k������");
		System.out.println(getNodeNumKthLevel(root, 3));
		System.out.println(getNodeNumKthLevelRec(root, 3));
		
		//����
		System.out.println("����");
		TreeNode find = search(root, 2);
		if(find!=null){
			System.out.println(find.val);
		} else{
			System.out.println("not find");
		}
		
		TreeNode find1 = search1(root, 4);
		if(find1!=null){
			System.out.println(find1.val);
		} else{
			System.out.println("not find");
		}
		
		System.out.println(depth(root));
	}
}
