package dfs;

import java.util.ArrayList;
import java.util.List;

//全排列
public class PermutationsI {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		helper(res, temp, visited, nums);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, boolean[] visited, int[] nums) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
//			temp.remove(temp.size() - 1);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				temp.add(nums[i]);
				visited[i] = true;
				helper(res, temp, visited, nums);
				visited[i] = false;
				temp.remove(temp.size() - 1);
			}
		}
	}
}
