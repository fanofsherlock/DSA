package Collections;

import java.util.HashMap;

public class gs {

	public static void main(String[] args) {
		int arr [] = {2,4,-5,8,-10};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int k =9; 
		
		//Single characters
		int otherChar;
		Integer val;
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], 0);
			
	     }
		
		for(int i=0;i<arr.length;i++) {
			otherChar = k - arr[i];
			val = map.get(otherChar);
			if(val!=null) {
				map.put(otherChar, val.intValue()+1);
			}
			
	     }
		
		
	}
	
	
}
