package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
	
	//重写toString方法,不重写的话对象toString是它的hash码
	@Override
	public String toString(){
		return Integer.toString(this.val);
		
	}
}
//定义一个内部类来表示深度
class Depth{
	int depth;
}
public class BinaryTreeDepth {

	/**
	 * 求二叉树的最小深度
	 * @param root
	 * @return
	 */
	public static int minDepthRec(TreeNode root){
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
		
		return Math.min(left, right)+1;
	}
	
		/*树的深度 
		 * 
		 * */
	
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
	public static int depthRec(TreeNode root){
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
	
	/*树的遍历
	 * 
	 * */
	
	
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
			
			//入栈时候先右后左，然后上一步的出栈才能先左后右
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
			//最左边的结点入栈
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			
			if(stack.isEmpty()){
				break;
			}
			
			//先树处理左边
			cur = stack.pop();
			System.out.print(cur.val+"-");
			
			//处理树的右边
			cur = cur.right;
		}
	}
	
	/**
	 * 递归中序遍历树
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
	 * 迭代后序遍历树
	 * @param root
	 */
	public static void postOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		//保存最后结果的栈
		LinkedList<TreeNode> result = new LinkedList<TreeNode>();

		
		TreeNode curNode = null;
		stack.push(root);
		
		while(!stack.isEmpty()){
			curNode = stack.pop();
			
			//后序遍历是左-右-中的顺序
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
	 * 递归后序遍历
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
	
	
	/*树的结点的插入 
	 * 
	 * */
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
	
	/*树的查找
	 * 
	 * */
	
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
	
	/**
	 * 递归计算树中一共有几个结点
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
	 * 迭代计算树中结点数
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
			//push(null)会把null也作为一个元素加到list中去，所以在这要做判断
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
	 * 按层遍历树
	 * @param root
	 */
	public static void levelTraversal(TreeNode root){
		if(root == null){
			return;
		}
		
		//新建一个列表，先进先出的
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode curNode = null;
		while(!queue.isEmpty()){
			//获取并得到队列头
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
	 * 使用递归来按层遍历树
	 * @param root
	 */
	public static void levelTraRec(TreeNode root){
		if(root == null){
			return;
		}
		
		//嵌套链表，每一层作为外层链表的一个结点，每一层中的结点又单独组成一个链表
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		
		//从第0层开始
		dfs(root,0,list);
		
		System.out.println(list);
	}
	
	/**
	 * 按层遍历的递归函数
	 * @param root 开始结点
	 * @param level 层数，从0层开始
	 * @param list 结果集
	 */
	public static void dfs(TreeNode root,int level,ArrayList<LinkedList<TreeNode>> list){
		if(root == null){
			return;
		}
		//list初始时size为0
		if(level >= list.size()){
			list.add(new LinkedList<TreeNode>());
		}
		
		list.get(level).add(root);
		
		//递归
		dfs(root.left,level+1,list);
		dfs(root.right,level+1,list);
		
	}
	
	/**
	 * 递归求二叉树第k层上的结点树
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
	 * 求二叉树第k层上的结点树
	 * 层序遍历，类似迭代求树的深度
	 * @param root
	 * @param k
	 * @return
	 */
	public static int getNodeNumKthLevel(TreeNode root,int k){
		if(root==null || k<0){
			return 0;
		}
		int curNodes = 1;	//当前层的结点数
		int nextNodes = 0;	//下一层结点数
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
	
	/**
	 * 递归求二叉树中叶子结点的个数
	 * @param root
	 * @return
	 */
	public static int getLeafNodeNumRec(TreeNode root){
		if(root == null){
			return 0;
		}
		
		//如果该结点没有左右结点，那它就是一个叶子结点
		if(root.left==null && root.right==null){
			return 1;
		}
		
		//如果当前结点不是叶子结点，则递归求它的左右子树的叶子结点的数目
		return getLeafNodeNumRec(root.left)+getLeafNodeNumRec(root.right);
	}
	
	/**
	 * 迭代法求二叉树中叶子结点的个数
	 * @param root
	 * @return
	 */
	public static int getLeafNodeNum(TreeNode root){
		
		if(root == null){
			return 0;
		}
		
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.push(root);
		TreeNode curNode = null;
		int leafNum = 0;
		
		while(!list.isEmpty()){
			curNode = list.pop();
			
			if(curNode.left != null){
				list.push(curNode.left);
			}
			if(curNode.right != null){
				list.push(curNode.right);
			}
			//如果当前结点是叶子结点，那叶子结点数+1
			if(curNode.left == null && curNode.right == null){
				leafNum++;
			}
		}
		return leafNum;
	}
	
	/**
	 * 递归判断两棵二叉树是否相同
	 * @param root
	 * @return
	 */
	public static boolean isSameTreeRec(TreeNode t1,TreeNode t2){
		if(t1==null && t2==null){
			return true;
		}
		else if(t1==null || t2==null){
			return false;
		}
		else if(t1.val == t2.val){
			return true;
		}
		
		return isSameTreeRec(t1.left,t2.left)&&isSameTreeRec(t2.right,t2.right);
	}
	
	/**
	 * 按层遍历判断两棵二叉树是否相同
	 * @param root
	 * @return
	 */
	public static boolean isSameTree(TreeNode t1,TreeNode t2){
		if(t1==null && t2==null){
			return true;
		}
		else if(t1==null || t2==null){
			return false;
		}
		
		LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
		
		list1.push(t1);
		list2.push(t2);
		
		TreeNode curNode1 = null;
		TreeNode curNode2 = null;
		
		while(!list1.isEmpty() && !list2.isEmpty()){
			curNode1 = list1.pop();
			curNode2 = list2.pop();
			
			if(curNode1.val != curNode2.val){
				return false;
			}
			
			if(curNode1.left!=null){
				list1.push(curNode1.left);
			}
			if(curNode1.right!=null){
				list1.push(curNode1.right);
			}
			if(curNode2.left!=null){
				list2.push(curNode2.left);
			}
			if(curNode2.right!=null){
				list2.push(curNode2.right);
			}
		}
		
		if(!list1.isEmpty() || !list2.isEmpty()){
			return false;
		}
		
		return true;
	}
	/**
	 * 输入一棵树的根节点，判断是否是平衡二叉树，使用了递归的方法
	 * 缺点是一个结点会被重复遍历多次，效率低
	 * @param root
	 * @return
	 */
	public static boolean isBalancedTreeRec(TreeNode root){
		if(root==null){
			return true;
		}
		
		int left = depth(root.left);
		int right = depth(root.right);
		
		int diff = left - right;
		//根节点满足平衡，接着判断其左结点和右结点
		if(diff<=1 && diff>=-1){
			return isBalancedTreeRec(root.left)&&isBalancedTreeRec(root.right);
		} else{
			return false;
		}
	}
	
	/**
	 * 用后序遍历的方式遍历二叉树的每一个结点，在遍历到一个结点之前我们已经遍历了它的左右子树。
	 * 遍历每个结点时记录下它的深度
	 * @param root
	 * @return
	 */
	
	public static boolean isBalancedTree(TreeNode root,Depth depth){
		if(root==null){
			depth.depth = 0;
			return true;
		}
		
		Depth leftDepth = new Depth();	//左子节点的深度
		Depth rightDepth = new Depth();	//右子节点的深度
		
		if(isBalancedTree(root.left, leftDepth) && isBalancedTree(root.right, rightDepth)){
			int diff = leftDepth.depth - rightDepth.depth;
			if(diff<=1 && diff>=-1){
				depth.depth = 1 + (leftDepth.depth>rightDepth.depth?leftDepth.depth:rightDepth.depth);
				return true;
			}
		}
		
		return false;
	}
	/**
	 * 输入某二叉树的前序遍历和中序遍历结果，重建二叉树
	 * @param preorder 前序遍历数组
	 * @param inorder  中序遍历数组
	 * @param length
	 * @return
	 */
	public static TreeNode construct(int[] preorder, int[] inorder, int length){
		if(preorder==null || inorder==null || length<=0){
			return null;
		}
		
		return constructCore(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	/**
	 * 剑指offer第六题
	 * 重建二叉树的子函数
	 * @param preorder 先序遍历数组
	 * @param sPre 先序遍历数组的起始位置
	 * @param ePre 先序遍历数组的结束位置
	 * @param inorder 中序遍历数组
	 * @param sIn 中序遍历数组的起始位置
	 * @param eIn 中序遍历数组的结束位置
	 * @return
	 */
	public static TreeNode constructCore(int[] preorder,int sPre,int ePre,int[] inorder,int sIn,int eIn){
		//前序遍历数组的第一个元素是根节点的值
		int rootValue = preorder[sPre];
		TreeNode root = new TreeNode(rootValue);
		
		//如果该树只有一个根节点，直接返回root
		if(sPre == ePre){
			if(sIn == eIn && preorder[sPre]==inorder[sIn]){
				return root;
			}
			else{
				System.out.println("输入数据不对");
				return null;
			}
		}
		
		//在中序遍历中找到根节点的值
		int rootInorder = sIn;
		while(rootInorder<=eIn && inorder[rootInorder]!= rootValue){
			rootInorder++;
		}
		//如果中序遍历数组中没有值等于根节点的元素，说明输入数据不对
		if(rootInorder==eIn && inorder[rootInorder]!= rootValue){
			System.out.println("输入数据不对");
			return null;
		}
		
		//计算根节点的左子树中元素的个数
		int leftLength = rootInorder - sIn;
		
		//得到左子树的在前序遍历数组中的结束位
		int leftPreEnd = sPre + leftLength;
		
		//如果左子树不为空
		if(leftLength > 0){
			//递归构建左子树
			root.left = constructCore(preorder, sPre+1, leftPreEnd, inorder, sIn, rootInorder-1);
		}
		
		//如果右子树不为空,即前序遍历数组中除了根节点和左子树元素外还有其他元素
		if(leftLength < ePre-sPre){
			//递归构建右子树
			root.right = constructCore(preorder, leftPreEnd+1, ePre, inorder, rootInorder+1, eIn);
		}
		
		return root;
		
	}
	
	
	
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(7);
		
		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(4);
		
		TreeNode test = new TreeNode(1);
		
		//构造树
		insertNode1(root, left);
		insertNode1(root, left);
		insertNode1(root, right);
		insertNode1(root, left2);
		insertNode1(root, right2);
		//insertNode1(root, test);
		/**
		 *           5
		 *          / \
		 *         3   7
		 *        / \
		 *       2   4
		 */

		
		
		System.out.println("树的深度为："+depthRec(root));
		System.out.println("树的深度为："+depth1(root));
		System.out.println("树的最小深度为："+minDepthRec(root));

		System.out.println("树中一共有多少个结点："+getNodeNum(root));
		System.out.println("树中一共有多少个结点："+getNodeNumRec(root));
		
		System.out.println("判断是否是平衡二叉树：");
		if(isBalancedTreeRec(root)){
			System.out.println("是平衡二叉树");
		}else{
			System.out.println("不是平衡二叉树");
		}
		System.out.println("判断是否是平衡二叉树：");
		if(isBalancedTree(root,new Depth())){
			System.out.println("是平衡二叉树");
		}else{
			System.out.println("不是平衡二叉树");
		}
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
		
		System.out.println("后序遍历：");
		postOrder(root);
		System.out.println();
		postOrderRec(root);
		System.out.println();
		
		
		System.out.println("按层遍历：");
		levelTraversal(root);
		System.out.println();
		levelTraRec(root);
		System.out.println();
		
		System.out.println("第k层结点数：");
		System.out.println(getNodeNumKthLevel(root, 3));
		System.out.println(getNodeNumKthLevelRec(root, 3));
		
		System.out.println("树中叶子结点数：");
		System.out.println(getLeafNodeNum(root));
		System.out.println(getLeafNodeNumRec(root));
		
		System.out.println("判断两棵树是否相同");
		if(isSameTree(root, root)){
			System.out.println("两棵树相同");
		} else{
			System.out.println("两棵树不同");
		}
		
		if(isSameTreeRec(root, root)){
			System.out.println("两棵树相同");
		} else{
			System.out.println("两棵树不同");
		}
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
		
		int[] preorder = {5,3,2,4,7};
		int[] inorder = {2,3,4,5,7};
		 
		TreeNode reTree = construct(preorder, inorder, preorder.length);
		inOrder(reTree);
		

	}
}
