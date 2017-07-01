package twoPoiniter;

public class ReverseString {
	public String reverseString(String s) {
		char[] result = s.toCharArray();
		for (int i = 0, j = result.length - 1; i < j; i++, j--) {
			char temp = result[i];
			result[i] = result[j];
			result[j] = temp;
		}
		return String.valueOf(result);
	}

}
