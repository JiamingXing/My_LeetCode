package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//但是纠结一个问题 我这个hashset不是全局变量会不会影响这道题的结果
//到底什么时候用全局变量这个问题还是没有搞清楚
public class SubSetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		//一开始没写这个sort 是因为没彻底理解题目的意思
		Arrays.sort(nums);
		List<List<Integer>> res= new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		helper(res, temp, nums, 0, set);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos, Set<List<Integer>> set) {
		//用一个hashSet避免重复相对还是会稍微慢一点
		//sort之后通过while循环跳过重复是最快的
		if (set.add(temp)) {
			res.add(new ArrayList<>(temp));
		}
		for (int i = pos; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(res, temp, nums, i+1, set);
			temp.remove(temp.size() - 1);
		}
		return;
	}

}

/*
public class SubSetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res= new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(res, temp, nums, 0);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos) {
		if (pos < nums.length) {
			res.add(temp);
		}
		for (int i = pos; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(res, temp, nums, i+1);
			temp.remove(temp.size() - 1);
			while (i < nums.length && nums[i] == nums[i-1]) {
				i++;
			}
		}
		return;
	}

}
*/
