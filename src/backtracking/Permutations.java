package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(res, temp, nums, 0);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i])) {
				continue;
			}
			temp.add(nums[i]);
			helper(res, temp, nums, 0);
			temp.remove(temp.size()-1);
		}
	}

}
