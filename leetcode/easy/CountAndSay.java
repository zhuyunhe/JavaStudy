package easy;

public class CountAndSay {
	public static String countAndSay(int n) {
		
		if(n<=0){
			return "";
		}  
	    String curRes = "1";  
	    for(int i=2;i<=n;i++){
	    	StringBuilder res = new StringBuilder();
	    	int count = 1;
	    	for(int j=1; j<curRes.length(); j++){
	    		if(curRes.charAt(j) == curRes.charAt(j-1)){
	    			count++;
	    		} else{
	    			res.append(count);
	    			res.append(curRes.charAt(j-1));  
	    	        count = 1;
	    		}
	    	}
	    	res.append(count);
	    	res.append(curRes.charAt(curRes.length()-1)); 
	    	curRes = res.toString();  
	    }
	    
	    return curRes;
    }
	
	public static void main(String[] args){
		System.out.println(countAndSay(4));
	}
}
