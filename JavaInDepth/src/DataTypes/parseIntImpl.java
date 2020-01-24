package DataTypes;

public class parseIntImpl {

	public static void main(String[] args) {
		String a = "123";
		String b = "abc";
		String c = "de1";
		String d = "";

		printParsedInt(c);
	}

	private static void printParsedInt(String s) {
		if (s == null || s.isEmpty() || s.isBlank()) {
			return;
		}

		int t = -1;
		int num = 0;

		for (int i = 0; i < s.length(); i++) {
			t = (int) s.charAt(i);
			if (t < 48 || t > 57) {
				return;
			}
			num = num * 10;
			num += (t - 48);

		}
		System.out.println(num);
	}

}
