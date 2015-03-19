package medium;
class TreeLinkNode {
	int val;
    TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
	}
public class RightPointerInNode {
	/**
	 * 第一次一次性通过
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
        if(root!=null && root.left!=null && root.right!=null){
        	root.left.next = root.right;
        	if(root.next!=null){
        		root.right.next = root.next.left;
        	}
        	
        	connect(root.left);
        	connect(root.right);
        }
    }
	
}
