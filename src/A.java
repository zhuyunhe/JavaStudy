
public class A {
	private int i;
	public A(int n){
		this.i = n;
	}
	
	public A(){
		System.out.println("父类无参构造器");
	}
	
	public static void main(String[] args){
		B b = new B();
	}
}

class B extends A{
	public B(){
		//默认自动调用了超类的无参构造器
	}
}
