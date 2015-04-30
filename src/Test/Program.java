package Test;

public class Program {
    public static int[] Puzzle(int[] a, int[] b) {
          quickSort(a, 0, a.length-1);
          quickSort(b,0,b.length-1);
          
          
          
          //int[] c = new int[Math.max(a.length,b.length)];
          int[] c = new int[a.length+b.length];

          int index = 0;
          int i=0;
          int j=0;
          while(i<a.length && j<b.length){
              if(a[i] == b[j]){
                c[index++] = a[i];
             }
              if(a[i]<b[j]){
            	  i++;
            	  }
              else if(a[i] > b[j]){
            	  j++;
            	  
              } else{
            	  i++;
            	  j++;
              }
          }
         
          if(c.length == 0){
        	  return null;
          }
          
          int len = 1;
          for(i=1; i<index; i++){
        	  if(c[i-1] != c[i]){
        		  len++;
        	  }
          }
          int[] d = new int[len];
          d[0] = c[0];
          for(i=1,j =1; i<index; i++){
        	  if(c[i-1] != c[i]){
        		  d[j++] = c[i];
        	  }
          }
		return d;
    }
    
    public static void main(String[] args){
    	int[] a = {11, 17, 6, 19};
    	int[] b = {24, 11, 19};
    	int[] c = Puzzle(a, b);
    	for(int i : c)
    	System.out.println(i);

    }
    
   public static int partition(int[] a,int begin,int end){
        int base=a[begin];
        int low=begin;
        int high=end;
        while(low<high){
            
            while(low<high&&base<=a[high]){
                high--;
            }
            a[low]=a[high];
            
            while(low<high&&base>=a[low]){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=base;
        return low;
    }
    static void quickSort(int[] a,int low,int high){
        if(low>=high)
            return;
        int index=partition(a, low, high);
        quickSort(a, low, index-1);
        quickSort(a, index+1, high);
    }

}
