package Hashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashLargestZeroSequence {

	public static void main(String[] args) {
     HashLargestZeroSequence hst = new HashLargestZeroSequence();
      
     ArrayList<Integer> test =  (ArrayList<Integer>) Stream.of(-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25  ).collect(Collectors.toList());
     ArrayList<Integer> result = hst.lszero(test);
     
     for (Integer integer : result) {
		System.out.print(integer+" ");
	}
     
	}

	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		// test cases when a is null
		if(A==null) {
			return new ArrayList<>();
		}
		// when a is empty
		if(A.size()==0) {
			return new ArrayList<>();
		}
		// when a has only one element
		if(A.size()==1) {
			if(A.get(0)==0){
				return A;
			}
			else {
				return new ArrayList<>();
			}
		}

		int LargestSize = 0;
		int startIndex=0;

		for (int i = 0; i < A.size(); i++) {

			if (LargestSize > (A.size() - i + 1)) {
				break;
			}

			sum = A.get(i);

			if (sum == 0 && LargestSize == 0) {

				map.put(i, i);
				LargestSize = 1;
				startIndex=i;

			}

			for (int j = i + 1; j < A.size(); j++) {
				sum = sum + A.get(j);

				if (sum == 0) {

					if ((j - i + 1) > LargestSize) {
						map.put(i, j);
						LargestSize = j -i+1;
						startIndex=i;
					}
				}

			}
		}

		int endIndex=0;
		
		if(map.containsKey(startIndex)) {
			endIndex = map.get(startIndex);
		}
		
		else {
			return new ArrayList<>();
		}
		
		return new ArrayList<Integer>(A.subList(startIndex, endIndex+1));
		
	}

}
