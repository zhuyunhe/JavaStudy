package tree;

import java.util.Iterator;
import java.util.LinkedList;

public class FindPath {
	public static void findPath(TreeNode root, int expectedNum){
		if(root==null){
			return;
		}
		LinkedList<Integer> path = new LinkedList<Integer>();
		
		int currentNum = 0;
		findPath(root, expectedNum, path, currentNum);
	}
	
	public static void findPath(TreeNode root, int expectedNum,LinkedList<Integer> path,int currentNum){
		if(root==null){
			return;
		}
		
		currentNum += root.val;
		path.add(root.val);
		
		boolean isLeaf = root.left==null && root.right==null;
		
		if(isLeaf && currentNum==expectedNum){
			System.out.println("found");
			Iterator<Integer> ite = path.iterator();
			while(ite.hasNext()){
				System.out.println(ite.next().intValue()+"-");
			}
		}
		
		//如果当前的root节点不是叶子结点，则分别遍历其左右子节点
		if(root.left!=null){
			findPath(root.left, expectedNum, path, currentNum);
		}
		if(root.right!=null){
			findPath(root.right, expectedNum, path, currentNum);
		}
		
		//当前节点已处理完，返回其父节点
		path.removeLast();
		
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
		
		findPath(tree1, 12);
	}
	
}
