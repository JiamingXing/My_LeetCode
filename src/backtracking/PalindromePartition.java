package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		helper(res, temp, 1, s);
		return res;
	}
	private void helper(List<List<String>> res, List<String> temp, int pos, String s) {
		if (s.equals("")) {
			List<String> list = new ArrayList<>(temp);
			res.add(list);
			return;
		}
		for (int i = pos; i <= s.length(); i++) {
			String st = s.substring(0, i);
			if (isPalindrome(st)) {
				temp.add(st);
				String rest = s.substring(i, s.length());
				helper(res, temp, 1, rest);
				temp.remove(temp.size() - 1);
			}
		}
	}
	private boolean isPalindrome(String s) {
		if (s.length() == 1) {
			return true;
		}
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(j);
			if (c1 != c2) {
				return false;
			}
		}
		return true;
	}

}
