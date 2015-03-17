package design_mode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OCP {
	 public static void invoker(){
	        Father f = new Father();
	        //出现父类的地方子类也可以出现
	        Son s = new Son();
	        HashMap map = new HashMap();
	        
	        //子类覆写/重载父类方法时,扩大了前置条件,这是对的,出现父类的地方可以用子类替换
	        f.doSomething(map); //syso：父类被执行
	        s.doSomething(map); //syso：父类被执行
	        
	        //子类覆写/重载父类方法时,缩小了前置条件,这是不对的,出现父类的地方不可以用子类替换
	        f.doS(map); //syso：父类被执行2
	        s.doS(map); //syso：子类被执行2
	        
	    }
	 	
	 	
	    public static void main(String[] args){
	        invoker();
	    }
	}

//父类
class Father{
    public Collection doSomething(HashMap map){
        System.out.println("父类被执行..");
        return map.values();
    }
    public Collection doS(Map map){
        System.out.println("父类被执行2..");
        return map.values();
    }
}
	
//子类
class Son extends Father{
    //重载,方法名相同但输入参数不同
    //子类重载了父类方法,但扩大了前置条件,所以子类的这个方法还是不会被执行,这样调用的时候就还是直接的父类方法
    //这才是想要的效果,体现了复用性,本来就该复用父类方法.
    public Collection doSomething(Map map){
        System.out.println("子类被执行..");
        return map.values();
    }
    
    //缩小了前置条件
    public Collection doS(HashMap map){
        System.out.println("子类被执行2..");
        return map.values();
    }
}
