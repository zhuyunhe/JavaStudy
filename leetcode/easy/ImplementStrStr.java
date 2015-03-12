package easy;

public class ImplementStrStr {
	public static int strStr(String haystack, String needle) {
		if(haystack == null || needle == null || haystack.length()<needle.length()){
			return -1;
		}
		if(needle.length() == 0){
			return 0;
		}
		
		for(int i=0; i<haystack.length()-needle.length()+1; i++){
			int pos = i;
			for(int j=0; j<needle.length(); j++){
				if(needle.charAt(j) == haystack.charAt(pos)){
					pos++;
				} else{
					break;
				}
				
				if(j == needle.length()-1){
					return i;
				}
			}
		}
		
		return -1;
        
    }
	
	public static void main(String[] args){
		String s1 = "mississippi";
		String s2 = "ssippi";
		System.out.println(strStr(s1, s2));
	}
}
