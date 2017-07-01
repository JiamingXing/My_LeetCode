package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length -3; i++) {
			//跳过重复元素找到最后一个重复元素
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j ++) {
				if (j > 0 && nums[j] == nums[j-1]) {
					continue;
				}
				int low = j + 1; 
				int high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if (sum == target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[low]);
						temp.add(nums[high]);
						result.add(temp);
						while (low < high && nums[low + 1] == nums[low]) {
							low ++;
						}
						while (low < high && nums[high - 1] == nums[high]) {
							high --;
						}
						low ++;
						high --;
					}else if (sum < target) {
						low ++;
					}else {
						high --;
					}
				}
			}
		}
		return result;
	}
}
