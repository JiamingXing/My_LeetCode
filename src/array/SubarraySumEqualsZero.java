package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsZero {
	public List<Integer> subarraySum(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				res.add(map.get(sum) + 1);
				res.add(i);
			} else {
				map.put(sum, i);
			}
		}
		return res;
	}
}
