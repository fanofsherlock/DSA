package Collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Optional;
import java.util.OptionalDouble;


public class CircularTour {

	
	public static void main(String[] args) {
		
		int petrol[] = {4,6,7,4};
		int distance[] = {6,5,3,5};
		
		Deque<Integer> d = (Deque<Integer>) new ArrayDeque(10);
		
		Arrays.stream(petrol).forEach(e->System.out.println(e));
		OptionalDouble opt = Arrays.stream(distance).map(e->e*e).average();
		
		Arrays.stream(petrol).map(e->e+1);
	}
}
