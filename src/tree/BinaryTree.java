package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
	 * 向树中某个节点插入一个节点
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
	
	//三种遍历方式

	/**
	 * 先序遍历,对节点的处理工作在它的诸儿子节点被处理前进行
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
	 * 后序遍历,对节点的处理工作在它的诸儿子节点被处理后进行
	 * @param root
	 */
	public void postorder(BinaryTree root){
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.val+",");
		}
	}

	/**
	 * 中序遍历
	 * @param root
	 */
	public void inorder(BinaryTree root){
		if(root != null){
			inorder(root.left);
			System.out.print(root.val+",");
			inorder(root.right);
		}
	}
	
	public List<BinaryTree> breadthFirst(BinaryTree root){
		Queue<BinaryTree> queue = new ArrayDeque<BinaryTree>();
		List<BinaryTree> list = new ArrayList<BinaryTree>();
		
		if(root != null){
			queue.offer(root);
		}
		
		while(!queue.isEmpty()){
			list.add(queue.peek());
			
			System.out.println(queue.peek().val);
			
			//获取并移除队列的头
			BinaryTree p = queue.poll();
			
			if(p.left!=null){
				//将元素插到队列尾部
				queue.offer(p.left);
			}
			
			if(p.right!=null){
				queue.offer(p.right);
			}
			
		}
		
		return list;
	}
	
	public static void main(String[] args){
		
		int[] array = {1,2,3,3,2};
		BinaryTree binaryTree = new BinaryTree(array[0]);
		for(int i=1;i<array.length;i++){
			binaryTree.insertNode(binaryTree, array[i]);       //向二叉树中插入数据
		}
		
		System.out.println("先序遍历");
		binaryTree.preorder(binaryTree);
		System.out.println();
		
		System.out.println("中序遍历");
		binaryTree.inorder(binaryTree);
		System.out.println();
		
		System.out.println("后序遍历");
		binaryTree.postorder(binaryTree);
		
		System.out.println("广度优先遍历");
		binaryTree.breadthFirst(binaryTree);
	}
	
}
