package tree;

import java.util.LinkedList;


/**
 * 二叉树节点
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
		
		//先判断根节点是否为null
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
	 * 递归的方法
	 * @param root
	 * @return
	 */
	public static int depth1(TreeNode root){
		//先判断根节点是否为null
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
	 * 迭代求树的深度
	 * @param root
	 * @return
	 */
	public static int depth2(TreeNode root){
		if(root == null){
			return 0;
		}
		int depth = 0;
		//当前层结点数
		int curNodes = 1;
		
		//下一层结点数
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
			
			//curNodes == 0 表示该层已结束，深度+1，转到下一层
			if(curNodes == 0){
				depth++;
				curNodes = nextNodes;
				nextNodes = 0;	//下一层结点数归零
			}
			
		}
		
		return depth;
	}
	
	/**
	 * 迭代先序遍历树
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
	 * 递归先序遍历树
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
	 * 迭代中序遍历树
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
	 * 插入一个节点
	 * @param root 根节点
	 * @param newNode 要插入的结点
	 * @return
	 */
	public static TreeNode insertNode(TreeNode root,TreeNode newNode){
		if(root == null){
			root = newNode;
		}
		
		//新结点的值小于根结点的值，插入到左子树中去
		else if(root.val>newNode.val){
			//如果结点左子树存在，把新结点插入左子树中
			if(root.left!=null){
				insertNode(root.left,newNode);
			} else{ //如果左子树不存在，则把新结点作为左子树
				root.left = newNode;
			}
		}//新结点的值大于根结点的值，插入到右子树中去
		else if(root.val<newNode.val){
			//如果结点右子树存在，把新结点插入右子树中
			if(root.right!=null){
				insertNode(root.right,newNode);
			} else{ //如果左子树不存在，则把新结点作为左子树
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
	 * 二叉排序树的二分查找
	 * 使用了迭代循环，没有使用递归
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode search(TreeNode root,int key){
		if(root == null){
			return null;
		}
		
		//使用循环时要注意判断root是否会为null，因为迭代过程中root一直在变
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
	 * 二叉排序树的二分查找
	 * 使用了递归
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
		
		//先判断根节点是否为null
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
		
		
		//构造树
		insertNode1(root, left);
		insertNode1(root, left);
		insertNode1(root, right);
		insertNode1(root, left2);
		insertNode1(root, right2);

		
		
		System.out.println("树的深度为："+depth2(root));
		System.out.println("树的深度为："+depth1(root));

		System.out.println("先序遍历：");
		preOrder(root);
		System.out.println();
		preOrderRec(root);
		System.out.println();
		
		
		System.out.println("中序遍历：");
		inOrder(root);
		System.out.println();
		inOrderRec(root);
		System.out.println();
		
		//查找
		System.out.println("查找");
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
