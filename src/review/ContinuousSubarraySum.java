package review;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		//考虑0的情况 [0,0]
		Map<Integer, Integer> map = new HashMap<>();
		//初始化0 -1很重要很重要
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) {
				sum = sum % k;
			}
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1) {
					return true;
				}
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}
}
