package easy;

public class LengthOfWord {
	public static int lengthOfLastWord(String s) {
		String[] arr = s.split(" ");
		if(arr.length != 0){
			char[] crr = arr[arr.length-1].toCharArray();
			return crr.length;
		} else{
			return 0;
		}
		
    }
	
	public static void main(String[] args){
		String str = "     ";
		int result = lengthOfLastWord(str);
		System.out.println(result);
	}
}
