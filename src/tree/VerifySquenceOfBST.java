package tree;

public class VerifySquenceOfBST {
	public static boolean verifySquOfBST(int[] seq,int start,int end){
		if(seq == null){
			return false;
		}
		int root = seq[end];
		
		//�������������������еĽڵ㶼С�ڸ��ڵ�
		int i=start;
		int leftCount = 0;	//�������ڵ���
		for(;i<end;i++,leftCount++){
			if(seq[i]>root){
				break;
			}
		}
		
		int j=i;
		int rightCount = 0;	//�������ڵ���
		for(;j<end;j++,rightCount++){
			if(seq[j]<root){
				return false;
			}
		}
		
		//������������ڵĻ����ݹ��ж��������ǲ��Ƕ���������
		boolean left = true;
		if(leftCount>0){
			left = verifySquOfBST(seq, start, i-1);
		}
		
		//������������ڵĻ����ݹ��ж��������ǲ��Ƕ���������
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
