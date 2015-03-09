package easy;

public class ValidPalindrome {
	public static  boolean validPalindrome(String s){
		String[] arr = s.split(" ");
		if(arr.length != 0){
			char[] crr = arr[arr.length-1].toCharArray();
			return true;
		} else{
			return true;
		}
	}
}
