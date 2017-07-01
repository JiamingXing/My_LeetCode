package review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence {
	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> temp = new ArrayList<>();
		helper(res, temp, nums, 0);
		List<List<Integer>> result = new ArrayList<>();
		result.addAll(res);
//		List result = new ArrayList<>(res);
		return result;
	}
	private void helper(Set<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
		if (temp.size() >= 2) {
			res.add(new ArrayList<>(temp));
		}
		for (int i = start; i < nums.length; i++) {
			if (temp.size() == 0 || temp.get(temp.size()-1) <= nums[i]) {
				temp.add(nums[i]);
				helper(res, temp, nums, i+1);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
