package design_mode;

import java.util.Vector;

//���۲��߳�����
abstract class Subject{
  //Vector���߳�ͬ����,��ȫ.ArrayList���߳��첽
  //����һ���۲�������
  private Vector<Observer> obsVector = new Vector<Observer>();
  
  //����һ���۲���
  public void addObserver(Observer o){
      this.obsVector.add(o);
  }
  
  //ɾ��һ���۲���
  public void delObserver(Observer o){
      this.obsVector.remove(o);
  }
  
  public int getVectorSize(){
      return this.obsVector.size();
  }
  
  //֪ͨ���й۲���
  public void notifyObservers(){
      for(Observer o : this.obsVector){
          o.update();
      }
  }
}
//�۲��߽ӿ�
interface Observer{
  public void update();
}

//һ��ʵ�ʱ��۲���
class ConcreteSubject extends Subject{
  public void doSomething(){
      System.out.println("���Ǳ��۲�Ķ���");
      
      //֪ͨ�۲��ҵ���
      super.notifyObservers();
  }
}

//һ��ʵ�ʵĹ۲���
class ConcreteObserver1 implements Observer{
  public void update(){
      System.out.println("�۲���1���յ���Ϣ������");
  }
}
//һ��ʵ�ʵĹ۲���
class ConcreteObserver2 implements Observer{
public void update(){
    System.out.println("�۲���2���յ���Ϣ������");
}
}

public class Observer_Client {
	 public static void main(String[] args){
	        //����һ�����۲���
	        ConcreteSubject subject = new ConcreteSubject();
	        
	        //����һ���۲���
	        Observer observer1 = new ConcreteObserver1();
	        
	        //����һ���۲���
	        Observer observer2 = new ConcreteObserver2();
	        
	        //�۲��߹۲챻�۲���
	        subject.addObserver(observer1);
	        subject.addObserver(observer2);
	        
	        //���۲��߿�ʼ�
	        subject.doSomething();
	    }
}
