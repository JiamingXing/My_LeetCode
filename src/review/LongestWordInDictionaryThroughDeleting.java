package review;
//之前做的permutation 所以我只要考虑字符对应的数量是否相等
//这道题对字符顺序有要求
//有点类似subsequence的问题 两个string同时从头到尾走就行了
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		int max = Integer.MIN_VALUE;
		String res = "";
		for (String word : d) {
			int i = 0;
			int j = 0;
			while (i < s.length()) {
				char c = word.charAt(j);
				if (s.charAt(i) == c) {
					j ++;
				}
				if (j == word.length()) {
					break;
				}
				i ++;
			}
			if (j == word.length()) {
				if (word.length() > max) {
					max = word.length();
					res = word;
				} else if (word.length() == max) {
					res = lexicographical(res, word);
				}
			}
		}
		return res;
	}
	private String lexicographical(String a, String b) {
		for (int i = 0; i < a.length(); i ++) {
			if (a.charAt(i) < b.charAt(i)) {
				return a;
			} else if (a.charAt(i) == b.charAt(i)) {
				continue;
			} else {
				return b;
			}
		}
		return a;
	}
}
