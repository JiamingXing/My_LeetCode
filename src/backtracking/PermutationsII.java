package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//这道题的关键就在于如何去规避重复元素
//先sort 然后	用一个used 来记录使用过的元素？
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(res, temp, nums, new boolean[nums.length]);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			temp.add(nums[i]);
			helper(res, temp, nums, used);
			used[i] = false;
			temp.remove(temp.size()-1);
		}
	}

}
