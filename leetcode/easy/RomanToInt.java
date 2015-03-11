package easy;

public class RomanToInt {
	/**
	 * 罗马数字转整数
	 * 罗马数字是右加左减
	 * 罗马数字共有7个，即I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		if(s==null || s.equals("")){
			return 0;
		}
		
		int result = 0;
		//保存第一个罗马数字的值作为临时变量
		int sub = getRomanValue(s.charAt(0));
		
		int tem = sub;
		
		for(int i=1; i<s.length(); i++){
			//得到当前这位的值
			tem = getRomanValue(s.charAt(i));
			
			//左边等于右边
			if(tem == sub){
				sub += tem;
			} else if(sub>tem){ //左边大于右边,先把左边加到结果中去
				result += sub;
				sub = tem;
			} else{ //左边小于右边
				sub = tem - sub;
			}
		}
		
		result += sub;
		
		
		return result;
    }
	public static int getRomanValue(char c) {  
        switch(c) {  
            case 'I': return 1;   
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0;  
        }  
    }  
	public static void main(String[] args){
		String s = "XCIX";
		System.out.println(romanToInt(s));
	}
}
