package binhexoct;

/**
 * 一般进制转换都以10进制数为基数进行，转换为2进制，8进制或16进制
 * Java的整型封装类Integer和Long提供toString(int i,int radix)静态方法，可以将一个任意进制的整数转换为其他进制的整数。
 * @author zhu
 *
 */
public class Convert {
	/**
	 * 十进制转二进制
	 * 也可以使用Integer或Long的toBinaryString方法将整数转换为二进制。
	 * @param num
	 */
	public static void toBin1(int num){
		//用一个可变的字符序列来保存转换结果
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num%2);
			num /=2;
		}
		//翻转得到正确的顺序，也可以用栈来存依次得到的各个数，最后在pop。
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * 十进制转二进制
	 * @param num
	 */
	public static void toBin2(int num){
		//用一个可变的字符序列来保存转换结果
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num&1);
			//无符号右移一位
			num = num >>> 1;
		}
		//翻转得到正确的顺序，也可以用栈来存依次得到的各个数，最后在pop。
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * 十进制转八进制
	 * 也可以使用Integer或Long的toOctalString方法将整数转换为八进制。
	 * @param num
	 */
	public static void toOct1(int num){
		//用一个可变的字符序列来保存转换结果
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num%8);
			num /=8;
		}
		//翻转得到正确的顺序，也可以用栈来存依次得到的各个数，最后在pop。
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * 十进制转八进制
	 * @param num
	 */
	public static void toOct2(int num){
		//用一个可变的字符序列来保存转换结果
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.append(num&7);
			//无符号右移一位
			num = num >>> 3;
		}
		//翻转得到正确的顺序，也可以用栈来存依次得到的各个数，最后在pop。
		sb.reverse();
		System.out.println(sb.toString());
	}
	/**
	 * 十进制转十六进制
	 * 也可以使用Integer或Long的toHexString方法将整数转换为十六进制。
	 * @param num
	 */
	public static void toHex1(int num){
		//用一个可变的字符序列来保存转换结果
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			int temp = num%16;
			if(temp > 9){
				//注意要把int转为char
				sb.append((char)('A'+temp-10));
			} else{
				sb.append(temp);
			}
			num /=16;
		}
		//翻转得到正确的顺序，也可以用栈来存依次得到的各个数，最后在pop。
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	/**
	 * 十进制转十六进制
	 * @param num
	 */
	public static void toHex2(int num){
		//用一个可变的字符序列来保存转换结果
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			int temp = num%16;
			if(temp > 9){
				//注意要把int转为char
				sb.append((char)('A'+temp-10));
			} else{
				sb.append(temp);
			}
			//无符号右移一位
			num = num >>> 4;
		}
		//翻转得到正确的顺序，也可以用栈来存依次得到的各个数，最后在pop。
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	public static void change(int num,int base, int offset){
        //通过数组来建立模板的表格
		char[] chs = {	'0','1','2','3'
						,'4','5','6','7'
						,'8','9','A','B'
						,'C','D','E','F'};
		char[] arr = new char[32];
		int len = arr.length;  
		//通过循环完成转换
		    while(num!=0){
		        int temp = num & base;
		        arr[--len]=chs[temp];
		        num = num>>>offset;
		    }
		    for(int i=0;i<arr.length;i++){
		    	//空字符就不打了
		    	if(arr[i] != '\0'){
		    	System.out.print(arr[i]);
		    	}
		    }
}
	public static void main(String[] args){
		int a = 12;
		toBin1(a);
		toBin2(a);
		toOct1(a);
		toOct2(a);
		toHex1(a);
		toHex2(a);
		change(a,15,4);
	}
}
