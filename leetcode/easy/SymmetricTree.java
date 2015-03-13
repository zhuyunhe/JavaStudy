package easy;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}
public class SymmetricTree {
	
	/**
	 * ������ȣ��ݹ�
	 * @param left
	 * @param right
	 * @return
	 */
	public static boolean valid(TreeNode left,TreeNode right){
		
		if(left ==null && right == null){
			return true;
		}
		if(left!=null && right!=null){
			if(left.val == right.val){
				//�����״�Ӧ���Ǵ��⵽��ıȽϽڵ�
				return valid(left.left,right.right) & valid(left.right,right.left);
				//return valid(left.left,left.right) & valid(right.left,right.right);
			}
		}
		
		return false;
	}
	public static boolean isSymmetric(TreeNode root) {
		if(root == null || (root.left==null && root.right==null)){
			return true;
		}
		return valid(root.left,root.right);
        
    }
	
	/**
	 * �����ⷨ
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric_1(TreeNode root) {
		if(root == null){
			return true;
		}
		
		Stack<TreeNode> ls = new Stack<TreeNode>();
		Stack<TreeNode> rs = new Stack<TreeNode>();
		
		TreeNode l;
		TreeNode r;
		
		//ջ�п�����nullԪ��
		ls.push(root.left);
		rs.push(root.right);
		
		
		while(!ls.isEmpty() && !ls.isEmpty()){
			l = (TreeNode) ls.pop();
			r = (TreeNode) rs.pop();
			
			if(l==null && r==null){
				continue;
			} 
			if(l==null || r==null){
				return false;
			}
			
			if(l.val != r.val){
				return false;
			}
			
			//��ʱl==r
			ls.push(l.left);
			ls.push(r.left);
			rs.push(r.right);
			rs.push(l.right);
		}
			
		return ls.isEmpty()&rs.isEmpty();
		
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(2);
		root.left = left;
		root.right = right;
		left.right = right2;
		right.left = left2;
		if(isSymmetric_1(root)){
			System.out.println("ok");
		}
		
	}
}
