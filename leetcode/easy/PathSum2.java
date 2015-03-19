package easy;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
	
	public List<List<Integer>> pathSum(TreeNode root,int sum){
		List<List<Integer>> listAll = new LinkedList<List<Integer>>();
		
		if(root == null){
			return listAll;
		}
		
		//����ýڵ���Ҷ�ӽڵ���val==sum,ֱ�ӷ���listAll
		if(root.val == sum && root.left==null && root.right==null){
			List<Integer> list = new LinkedList<Integer>();
			list.add(root.val);
			listAll.add(list);
			return listAll;
		}
		
		listAll.addAll(pathSum(root.left,sum-root.val));
		listAll.addAll(pathSum(root.right,sum-root.val));
		
		//��ǰ�ڵ㲻��Ҷ�ӽڵ�ʱ,Ҫ�ѵ�ǰ�ڵ��ֵ�ӻص�������ȥ
		for(List<Integer> l: listAll){
			l.add(0, root.val);
		}
		
		return listAll;
	}
	
	public static void main(String[] args){
		PathSum2 ps = new PathSum2();
		
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		TreeNode right2 = new TreeNode(1);
		root.left = left1;
		root.right = right1;
		left1.right = right2;
		System.out.println(ps.pathSum(root, 4));
	}
}
