package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> depthList = new ArrayList<List<Integer>>();
		put(root, depthList, 0);
		return depthList;
        
    }
	
	public static void put(TreeNode node,List<List<Integer>> list,int depth){
		if(node == null){
			return;
		}
		if(list.size()==depth){
			list.add(new ArrayList<Integer>());
		}
		
		list.get(depth).add(node.val);
		
		put(node.left, list, depth+1);
		put(node.right, list, depth+1);
	}
	
	/**
	 * 广度优先遍历
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root==null){
            return ret;
        }
        
        List<TreeNode> level = new LinkedList<TreeNode>();
       level.add(root);
        while(true){
        	if(level==null || level.isEmpty()){
        		return ret;
        	}
        	List<Integer> currentList = new LinkedList<Integer>();
        	List<TreeNode> nextLevel = new LinkedList<TreeNode>();
        	for(TreeNode node : level){
        		currentList.add(node.val);
        		if(node.left!=null) nextLevel.add(node.left);
        		if(node.right!=null) nextLevel.add(node.right);
        	}
        	//插入列表开头
        	ret.addFirst(currentList);
        	level = nextLevel;
        }
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		
		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(4);
		
		root.left = left;
		root.right = right;
		left.left = left2;
		right.right = right2;
		
		List<List<Integer>> list = levelOrder(root);
		System.out.println(list);
	}
}
