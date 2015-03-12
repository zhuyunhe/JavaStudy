package easy;

public class ImplementStrStr {
	public static int strStr(String haystack, String needle) {
		if(haystack == null || needle == null){
			return 0;
		}
		int flag = 0;
		for(int i=0; i<haystack.length()-needle.length();i++){
			for(int j=0; j<needle.length(); j++){
				int pos = i;
				if(haystack.charAt(pos) != needle.charAt(j)){
					break;
				}
				pos++;
				if(j == needle.length()-1){
					flag = i;
				}
			}
		}
        return flag;
    }
	
	public static void main(String[] args){
		String s1 = "abcdef";
		String s2 = "cde";
		System.out.println(strStr(s1, s2));
	}
}
