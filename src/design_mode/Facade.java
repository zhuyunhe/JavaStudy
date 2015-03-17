package design_mode;

//��ϵͳA
class ClassA{
  public void doSomethingA(){
      System.out.println("Aϵͳ����");
  }
}
//��ϵͳC
class ClassB{
public void doSomethingB(){
    System.out.println("Bϵͳ����");
}
}
//��ϵͳC
class ClassC{
public void doSomethingC(){
    System.out.println("Cϵͳ����");
}
}

//������
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
