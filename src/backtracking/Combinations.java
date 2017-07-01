package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(res, temp, 1, n, k);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, int pos, int n, int k) {
		if (k == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = pos; i <= n-k+1; i++) {
			temp.add(i);
			helper(res, temp, i+1, n, k-1);
			temp.remove(temp.size()-1);
		}
	}

}
