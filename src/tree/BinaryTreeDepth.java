package tree;

import java.util.LinkedList;


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
}

public class BinaryTreeDepth {
	
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
	public static int depth2(TreeNode root){
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
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			
			if(stack.isEmpty()){
				break;
			}
			
			cur = stack.pop();
			System.out.print(cur.val+"-");
			cur = cur.right;
		}
	}
	
	public static void inOrderRec(TreeNode root){
		if(root == null){
			return;
		}
		inOrderRec(root.left);
		System.out.print(root.val+"-");
		inOrderRec(root.right);
	}
	
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
	public static int depth_1(TreeNode root){
		
		//���жϸ��ڵ��Ƿ�Ϊnull
		if(root == null){
			return 0;
		}
		
		int left = 0;
		if(root.left != null){
			left += depth(root.left);
			
		}
		
		int right = 0;
		if(root.right != null){
			right += depth(root.right);
			
		}
		
		return Math.max(left, right) +1;
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

		
		
		System.out.println("�������Ϊ��"+depth2(root));
		System.out.println("�������Ϊ��"+depth1(root));

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
