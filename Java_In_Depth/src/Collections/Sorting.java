package Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {

	public static void main(String[] args) {
		
		String arr[] = {"practice.geeksforgeeks.org", 
                "quiz.geeksforgeeks.org", 
                "code.geeksforgeeks.org"
               }; 
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		
		
		Arrays.sort(arr, new StringComparator());
        System.out.println(Arrays.toString(arr));  
        
        
        
	}
		
	
	static class StringComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
		       if((int)o1.charAt(0) < (int) o2.charAt(0)) {
		    	   return 1;
		       }

		       else if ((int)o1.charAt(0) > (int) o2.charAt(0)) {
		    	   return -1;
		       }
		       
		       
			return 0;
		}
	}

}
