package backtracking;

import java.util.ArrayList;
import java.util.List;
//这道题为什么变个花样就让你无从下手？本质还是一样的好好反思一下
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, "", 0, 0, n);
		return res;
	}
	private void helper(List<String> res, String s, int open, int close, int n) {
		if (s.length() == 2*n && open == n && close == n) {
			res.add(s);
			return;
		}
		if (open < n) {
			helper(res, s + "(", open + 1, close, n);
		}
		//close < open细节注意
		if (close < open) {
			helper(res, s + ")", open, close + 1, n);
		}
	}

}
