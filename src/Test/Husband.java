package Test;

public class Husband {  
    
    /* 
     * �����Եķ�װ 
     * һ���˵��������Ա����䡢���Ӷ�������˵�˽������ 
     */  
	private String name ;  
    private String sex ;  
    private int age ;  
    private Wife wife;  
      
    /* 
     * setter()��getter()�Ǹö�����⿪���Ľӿ� 
     */  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getSex() {  
        return sex;  
    }  
  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public void setWife(Wife wife) {  
        this.wife = wife;  
    }
    
    public static void main(String args){
    	Husband h = new Husband();
    	h.age = 10;
    }
}
class Wife {  
    private String name;  
    private int age;  
    private String sex;  
    private Husband husband;  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getSex() {  
        return sex;  
    }  
  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public void setHusband(Husband husband) {  
        this.husband = husband;  
    }  
  
    public Husband getHusband() {  
        return husband;  
    }  
      
}  
