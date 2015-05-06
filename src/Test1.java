public class Test1{
    public static void main(String args[]){
            String a="1234";
            String b="1234";
            String c = new String("1234");
            System.out.println(a==b);
            System.out.println(a==c);
            System.out.println(a.equals(c));
            int[] arr = {1,3,7,9,9,5,4,3,6,1,7};
            find(arr,arr.length);
    }
    
    /**
     * 得到num的二进制数中第一个为1的位的位置的函数
     * @param num
     * @return 二进制数中1出现的最低位的位置
     */
    public static int getFirstOnePos(int num){
    	int pos = 1;
    	//找到num的二进制数中第一个为1的位的位置
    	while((num&0x01)==0){
    		num = num>>1;
    		pos++;
    	}
    	return pos;
    }
    
    /**
     * 用来分组的函数
     * 如果地pos位为1，那么返回true。
     * @param num 要进行分组的数
     * @param pos 位置
     * @return
     */
    public static boolean divide(int num,int pos){
    	num = num>>(pos-1);
    	return (num&0x01)==1?true:false;
    }
    
    /**
     * 查找出数组中两个只出现过一次的数
     * @param a 要查找的数组
     * @param n 数组长度
     */
    public static void find(int[] a,int n){
    		int num1 = 0;
    		int num2 = 0;
          	int povit = 0;
          	//0异或数组中每一个元素，得到那两个只出现过一次的元素的异或值
          	for(int i=0;i<n;i++){
          		povit ^= a[i];
          	}
          	
          	//找到a^b的二进制表示中第一个为1的位置
          	int pos = getFirstOnePos(povit);
          	
          	for(int i=0; i<n; i++){
          		//分组
          		//第一组是pos位为1的
          		if(divide(a[i],pos)){
          			//用异或求出改组中唯一出现过一次数
          			num1 ^= a[i];
          		} else{ //第二组是pos位为0的
          			num2 ^= a[i];
          		}
          	}
          	System.out.println(num1);
          	System.out.println(num2);
          	
    }
}