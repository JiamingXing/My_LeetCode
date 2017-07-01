package review;

import java.util.HashMap;
import java.util.Map;
//看一下leetcode上之前提交的没通过的写法 我感觉这道题问题很大。
public class SubarraySumK {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				res += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
}
