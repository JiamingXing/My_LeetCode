package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(res, temp, 1, k, n);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, int pos, int k, int n) {
		if (k == 0) {
			//这里为什么要new一个arraylist
			//List<Integer> list = new ArrayList<>(temp);
			//res.add(list);
			//直接add temp 是不行的？
			//解答：因为加的是temp这个referece 我后面一直在对temp指向的list改变操作
			//如果直接加temp的话 加进去的东西也一直在变动！！！ 很低级的错误 要copy一个新的list
			if (n == 0) {
				res.add(temp);
				return;
			}
			return;
		}
		for (int i = pos; i <= 9 - k + 1; i++) {
			temp.add(i);
			helper(res, temp, i + 1, k -1, n-i);
			temp.remove(temp.size() - 1);
		}
	}
}
