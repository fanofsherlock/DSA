package BasicTricky;

import java.util.Arrays;

/*
 https://www.geeksforgeeks.org/valid-variants-main-java/?ref=rp
 * 
 */

class executeParent {

	public static void main(String[] args) {
		System.out.println("Parent main Method");
	}
}

public class MainMethodIdioSyncracy extends executeParent {

	
	public final static synchronized strictfp void main(String[] args) {
		System.out.println("Child main Method");
	}
	
	// This method is never called first even with integer params
	public static void main(int[] args) {
		Arrays.stream(args).forEach(System.out::println);
	}

}
