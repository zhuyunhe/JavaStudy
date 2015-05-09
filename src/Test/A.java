package Test;

class F{
	String name;
	public F(String s){
		this.name = s;
		System.out.println(s);
	}
	
	public F(){
		System.out.println("hello");
	}
}

class S extends F{
	
}

public class A {
	public static void main(String[] args){
		S s = new S();
	}
}
