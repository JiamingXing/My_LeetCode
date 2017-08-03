package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//带重复元素
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		helper(res, temp, visited, nums);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, boolean[] visited, int[] nums) {
		if (temp.size() == nums.length) {
			if (!res.contains(temp)) {
				res.add(new ArrayList<>(temp));
			}
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				temp.add(nums[i]);
				visited[i] = true;
				helper(res, temp, visited, nums);
				visited[i] = false;
				temp.remove(temp.size() - 1);
				while (i < nums.length-1 && nums[i+1] == nums[i]) {
					i ++;
				}
			}
		}
	}
}

/*
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		helper(res, temp, visited, nums);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, boolean[] visited, int[] nums) {
		if (temp.size() == nums.length) {
			if (!res.contains(temp)) {
				res.add(new ArrayList<>(temp));
			}
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
*/
