package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
	/**
	Implement the next permutation, which rearranges numbers into the numerically 
	next greater permutation of numbers for a given array A of size N.

    If such arrangement is not possible,
    it must be rearranged as the lowest possible order i.e., sorted in an ascending order.
	 
	 */

	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
		int n = A.size();
		int k = -1;
		int l = 0;

		
		for (int i = 0; i < n - 1; i++) {
			if (A.get(i) < A.get(i + 1))
				k = i;
		}
        
		//If (K==-1) means all elements are arranged in descending order
		//which is the last possible permutation, hence we return all 
		//elements in ascending order
		if (k == -1) {
			Collections.sort(A);
			return A;
		}

		//or we found the latest element which is smaller then its next element
		
		//now we will find the element to the right of K, which might be larger than K
		//we find the last such element
		for (int i = k + 1; i < n; i++) {
			if (A.get(i) > A.get(k)) {
				l = i;
			}
		}
		
		//Swap l with K 
		int temp = A.get(l);
		A.set(l, A.get(k));
		A.set(k, temp);
		
		//then we swap all elements from 
		//K+1 to n-1;
		int j = k + 1;
		int last = n - 1;
		while (j <= last) {
			temp = A.get(j);
			A.set(j, A.get(last));
			A.set(last, temp);
			j++;
			last--;
		}

		return A;
	}

}
