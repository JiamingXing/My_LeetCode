package bitmanipulation;
// 任何数字和0异或都是其自身，任何数字和自身异或都等于0
public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		char c = '0';
		for (int i = 0; i < s.length(); i++) {
			c ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			c ^= t.charAt(i);
		}
		return c;
	}
}
