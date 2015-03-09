package easy;



public class MinStack {
	Node top = null;
	
	public void push(int x) {
       if(top == null){
    	   top = new Node(x);
    	   top.min = x;
       } else{
    	   Node tem = new Node(x);
    	   tem.next = top;
    	   top = tem;
    	   top.min = Math.min(top.next.min, x);
       }
    }

    public void pop() {
    	if(top != null){
    		top = top.next;
    	}
    	return;
    }

    public int top() {
    	return top==null?0:top.val;
    }

    public int getMin() {
    	return top==null?0:top.min;
    }
    class Node{
    	private int val;
    	private int min;
    	Node next;
    	
    	public Node(int x){
    		this.val=x;
    	}
    }
    public static void main(String[] args){
    	MinStack ms = new MinStack();
    	ms.pop();
    	/*ms.push(-2);
    	ms.push(0);
    	ms.push(-1);
    	System.out.println(ms.getMin());
    	System.out.println(ms.top());
    	ms.pop();
    	System.out.println(ms.getMin());*/

    }
}
