package swap;

public class TestData {
	private String name;
	
	public TestData(String _name){
		this.name = _name;
	}
	
	public static void swap(TestData d1,TestData d2){
		TestData temp = d1;
		d1 = d2;
		d2 = temp;
	}

	
	//这种方法是换不过来的啦
	public static void swap1(int d1,int d2){
		d1 = d1 + d2;
		d2 = d1 - d2;
		d1 = d1 -d2;
	}
	
	public static void main(String[] args){
		TestData d1 = new TestData("zhu");
		TestData d2 = new TestData("li");
		swap(d1, d2);
		System.out.println(d1.name +"--"+ d2.name);
		int i = 1;
		int j = 2;
		swap1(i, j);
		System.out.println(i +"--"+ j);
		
	}
}
