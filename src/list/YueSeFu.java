package list;
/**
 * Լɪ������
 * @author rttd
 *
 */
public class YueSeFu {
	public static void main(String[] args){
		System.out.println(lastRemain(4, 1));
	}
	
	public static int lastRemain(int n, int m){
		if(n<1 || m<1){
			return -1;
		}
		
		int last = 0;
		
		for(int i=2; i<=n;i++){
			last = (last+m)%i;
		}
		  return last;
	}
}
