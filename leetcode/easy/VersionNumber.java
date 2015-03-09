package easy;

public class VersionNumber {
	public static int compareVersion(String version1, String version2) {
		//×ªÒå×Ö·û.
		String[] list1 = version1.split("\\.");
		String[] list2 = version2.split("\\.");

		int size = Math.min(list1.length, list2.length);
		
		for(int i=0; i<size;i++){
			if(Integer.valueOf(list1[i]) < Integer.valueOf(list2[i])){
				return -1;
			} else if(Integer.valueOf(list1[i]) > Integer.valueOf(list2[i])){
				return 1;
			} 
		}
		
		if(list1.length>size){
			if(Integer.valueOf(list1[size])>0){
				return 1;
			}
		}
		
		if(list2.length>size){
			if(Integer.valueOf(list2[size])>0){
				return -1;
			}
		}
		
		
		
		return 0;
		
    }
	
	public static void main(String[] args){
		int result = compareVersion("1","1.1");
		System.out.println(result);
	}
}
