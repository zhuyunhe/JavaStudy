package tree;

public class VerifySquenceOfBST {
	public static boolean verifySquOfBST(int[] seq,int start,int end){
		if(seq == null){
			return false;
		}
		int root = seq[end];
		
		//二叉搜索树的左子树中的节点都小于根节点
		int i=start;
		int leftCount = 0;	//左子树节点数
		for(;i<end;i++,leftCount++){
			if(seq[i]>root){
				break;
			}
		}
		
		int j=i;
		int rightCount = 0;	//右子树节点数
		for(;j<end;j++,rightCount++){
			if(seq[j]<root){
				return false;
			}
		}
		
		//如果左子树存在的话，递归判断左子树是不是二叉搜索树
		boolean left = true;
		if(leftCount>0){
			left = verifySquOfBST(seq, start, i-1);
		}
		
		//如果右子树存在的话，递归判断右子树是不是二叉搜索树
		boolean right = true;
		if(rightCount>0){
			right = verifySquOfBST(seq, i, end-1);
		}
		
		return left&right;
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

		int[] seq = {7,4,6,5};
		if(verifySquOfBST(seq, 0, seq.length-1)){
			System.out.println("ok");
		} else{
			System.out.println("nono");
		}
	}
}
