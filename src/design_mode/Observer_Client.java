package design_mode;

import java.util.Vector;

//被观察者抽象类
abstract class Subject{
  //Vector是线程同步的,安全.ArrayList是线程异步
  //定义一个观察者数组
  private Vector<Observer> obsVector = new Vector<Observer>();
  
  //增加一个观察者
  public void addObserver(Observer o){
      this.obsVector.add(o);
  }
  
  //删除一个观察者
  public void delObserver(Observer o){
      this.obsVector.remove(o);
  }
  
  public int getVectorSize(){
      return this.obsVector.size();
  }
  
  //通知所有观察者
  public void notifyObservers(){
      for(Observer o : this.obsVector){
          o.update();
      }
  }
}
//观察者接口
interface Observer{
  public void update();
}

//一个实际被观察者
class ConcreteSubject extends Subject{
  public void doSomething(){
      System.out.println("我是被观察的对象");
      
      //通知观察我的人
      super.notifyObservers();
  }
}

//一个实际的观察者
class ConcreteObserver1 implements Observer{
  public void update(){
      System.out.println("观察者1接收到消息并处理");
  }
}
//一个实际的观察者
class ConcreteObserver2 implements Observer{
public void update(){
    System.out.println("观察者2接收到消息并处理");
}
}

public class Observer_Client {
	 public static void main(String[] args){
	        //创建一个被观察者
	        ConcreteSubject subject = new ConcreteSubject();
	        
	        //定义一个观察者
	        Observer observer1 = new ConcreteObserver1();
	        
	        //定义一个观察者
	        Observer observer2 = new ConcreteObserver2();
	        
	        //观察者观察被观察者
	        subject.addObserver(observer1);
	        subject.addObserver(observer2);
	        
	        //被观察者开始活动
	        subject.doSomething();
	    }
}
