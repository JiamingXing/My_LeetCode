package review;

import java.util.Arrays;

public class KDiffPairs {
	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0){
			return 0;
		}
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			//用if写不用while写规避了一些特殊的case[1,1,1,1]
			if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
			for (int j = i+1; j < nums.length; j ++) {
				if(nums[j] - nums[i] > k){
                    break;
                }
				if (nums[j] - nums[i] == k) {
					res ++;
					break;
				}
			}
		}
		return res;
	}
}
