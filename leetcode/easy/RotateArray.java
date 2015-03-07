package easy;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
        int num = nums.length;
        if(k<=num){
	        for(int i=0;i<k;i++){
	            int temp = nums[num-1];
	            for(int j=num;j>1;j--){
	                nums[j-1] = nums[j-2];
	            }
	            nums[0] = temp;
	        }
        } else{
        	k = k-nums.length;
        	rotate(nums,k);
        }
    }
	
	public static void rotate_1(int[] nums, int k) {
       int size = nums.length;
       k %= size;
       
       if(size == 1){
    	   return;
       }
       
       if(k == 0){
    	   return;
       }
       
       reversal(nums, 0, size - k - 1);

       reversal(nums, size -k, size - 1);

       reversal(nums, 0, size - 1);
    }
	
	private static void reversal(int[] nums, int i, int j) {
		int temp;
		while(i<j && i>=0){
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
		
	}

	public static void main(String[] args){
		int[] a = {1,2,3,4};
		rotate_1(a, 3);
		for(int i : a){
			System.out.print(i+",");
		}
	}
}
