package Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReOrderLines {

	public static List<String> rLines(int szie, List<String> lines) {
		Comparator<String> c1 = (a, b) -> compare(a, b);
		return lines.stream().sorted(c1).collect(Collectors.toList());
	}

	
	
	private static int compare(String a, String b) {
		String[] s1 = a.split(" ");
		String[] s2 = b.split(" ");

		int f1 = s1[1].charAt(0);
		int f2 = s2[1].charAt(0);

		//in case of logiles containing numbers
		if (f1 < 97 && f2 < 97) {
			return 0;
		}

		//in case logfile A contains numbers
		if (f1 < 97) {
			return 1;
		}

		//in case logfile B contains numbers
		if (f2 < 97) {
			return -1;
		}

		
		int res = s1[1].compareTo(s2[1]);
		
		if(res!=0) {
			return res;
		}
		
		int startIndex = 2;
		while (startIndex < s1.length && startIndex < s2.length && res==0) {
			res=s1[startIndex].compareTo(s2[startIndex]);
			if(res!=0) {
				return res;
			}
			startIndex++;
		}
		
		if(s1.length==s2.length) {
			return s1[0].compareTo(s2[0]);
		}
		
		return s1.length>s2.length?-1:1;

	}
	
	/*
	 1) Words lines come first 
	 2) Words lines should be lexographically sorted 
	 3) Numbers lines should  come next and should be in insertion order (stable sort)
	 4) If two words lines are equal then sort based on identifier
	 
	 */
	
	

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("mi2 alps cow pet ram shyam");
		list.add("m21 alps cow pet");
		
		
		list.add("wz3 34 54 398");
		list.add("a1 alps mid bar");
		list.add("x4 45 21 7");

		List<String> l2 = rLines(0, list);
		for (String s : l2) {
			System.out.println(s);
		}

	}

}
