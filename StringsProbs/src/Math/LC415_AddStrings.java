package Math;

public class LC415_AddStrings {

	public String addStrings(String num1, String num2) {
		if (num1.trim().equals("") && num2.trim().equals("")) {
			return "";
		}

		if (num1.trim().equals("")) {
			return num2;
		}

		if (num2.trim().equals("")) {
			return num1;
		}

		return stringAddition(num1, num2);
	}

	public String stringAddition(String num1, String num2) {

		StringBuilder sb = new StringBuilder();

		int i = num1.length()-1, j = num2.length()-1;
		int n1 = 0, n2 = 0, carry = 0;

		while (i>=0&&j >= 0) {
			n1 = num1.charAt(i--) - '0';
			n2 = num2.charAt(j--) - '0';
			sb.append((n1 + n2 + carry) % 10);
			carry = (n1 + n2+carry) / 10;
		}

		while (i >= 0) {
			n1 = num1.charAt(i--) - '0';
			sb.append((n1 + carry) % 10);
			carry = (n1+carry) / 10;
		}
		
		while (j >= 0) {
			n2 = num2.charAt(j--) - '0';
			sb.append((n2 + carry) % 10);
			carry = (n2+carry) / 10;
		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		LC415_AddStrings str = new LC415_AddStrings();
		System.out.println(str.addStrings("6", "501"));
	}

}
