
public class A {
	private int i;
	public A(int n){
		this.i = n;
	}
	
	public A(){
		System.out.println("�����޲ι�����");
	}
	
	public static void main(String[] args){
		B b = new B();
	}
}

class B extends A{
	public B(){
		//Ĭ���Զ������˳�����޲ι�����
	}
}
