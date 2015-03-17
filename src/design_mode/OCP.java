package design_mode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OCP {
	 public static void invoker(){
	        Father f = new Father();
	        //���ָ���ĵط�����Ҳ���Գ���
	        Son s = new Son();
	        HashMap map = new HashMap();
	        
	        //���าд/���ظ��෽��ʱ,������ǰ������,���ǶԵ�,���ָ���ĵط������������滻
	        f.doSomething(map); //syso�����౻ִ��
	        s.doSomething(map); //syso�����౻ִ��
	        
	        //���าд/���ظ��෽��ʱ,��С��ǰ������,���ǲ��Ե�,���ָ���ĵط��������������滻
	        f.doS(map); //syso�����౻ִ��2
	        s.doS(map); //syso�����౻ִ��2
	        
	    }
	 	
	 	
	    public static void main(String[] args){
	        invoker();
	    }
	}

//����
class Father{
    public Collection doSomething(HashMap map){
        System.out.println("���౻ִ��..");
        return map.values();
    }
    public Collection doS(Map map){
        System.out.println("���౻ִ��2..");
        return map.values();
    }
}
	
//����
class Son extends Father{
    //����,��������ͬ�����������ͬ
    //���������˸��෽��,��������ǰ������,�������������������ǲ��ᱻִ��,�������õ�ʱ��ͻ���ֱ�ӵĸ��෽��
    //�������Ҫ��Ч��,�����˸�����,�����͸ø��ø��෽��.
    public Collection doSomething(Map map){
        System.out.println("���౻ִ��..");
        return map.values();
    }
    
    //��С��ǰ������
    public Collection doS(HashMap map){
        System.out.println("���౻ִ��2..");
        return map.values();
    }
}
