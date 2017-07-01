package dfs;
//本体关键利用hashset和Arraylist之间的联系 直接规避重复的情况
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<Integer> temp = new ArrayList<>();
		Set<List<Integer>> res = new HashSet<>();
		helper(res, temp, 0, nums);
		//List result = new ArrayList(res); 应该这样写
		//list interface 的用法？？？？？？？？？ 还不会？？？
		//set可以规避重复 这是这道题的关键
		//set和list之间可以直接相互转换？
		List<List<Integer>> result = new ArrayList<>(res);
		return result;
	}
	public void helper(Set<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
		if (temp.size() >= 2) {
			//黄色叹号的问题？
			res.add(new ArrayList<Integer>(temp));
		}
		for (int i = start; i < nums.length; i++) {
			if (temp.size() == 0 || temp.get(temp.size() - 1) < nums[i]) {
				temp.add(nums[i]);
				helper(res, temp, i + 1, nums);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
