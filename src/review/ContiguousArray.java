package review;

import java.util.HashMap;
import java.util.Map;

// -> maximum contiguous subarray sum 
public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int sum = 0;
		//一开始自己没加这一句
		//[0,1]这个case没通过
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return max;
	}
}
