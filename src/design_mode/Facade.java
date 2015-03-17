package design_mode;

//子系统A
class ClassA{
  public void doSomethingA(){
      System.out.println("A系统工作");
  }
}
//子系统C
class ClassB{
public void doSomethingB(){
    System.out.println("B系统工作");
}
}
//子系统C
class ClassC{
public void doSomethingC(){
    System.out.println("C系统工作");
}
}

//门面类
public class Facade {
	private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();
    
    public void methodA(){
        a.doSomethingA();
    }
    public void methodB(){
        b.doSomethingB();
    }
    public void methodC(){
        c.doSomethingC();
    }
    
    public static void main(String[] args){
        Facade f =new Facade();
        f.methodA();
        f.methodB();
        f.methodC();
    }
}
