package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			StringBuilder sb = new StringBuilder();
			int temp = i;
			while (i+1 < nums.length && nums[i+1] == nums[i]+1) {
				i++;
			}
			if (temp == i) {
				sb.append(nums[i]);
				res.add(sb.toString());
			} else {
				sb.append(nums[temp]);
				sb.append("->").append(nums[i]);
				res.add(sb.toString());
			}
		}
		return res;
	}
}
