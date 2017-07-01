package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//implement O(n^2) first then improve to O(nlogn)
//这个自己写的用hashmap的方法慢到极致 非常的笨
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int result = 1;
		Map<Integer, Integer> map = new HashMap<>();
		int[] dp = new int[nums.length];
		dp[0] = 1;
		map.put(nums[0], 0);
		for (int i = 1; i < dp.length; i++) {
			int max = 1;
			for (int keys : map.keySet()) {
				if (keys < nums[i]) {
					max = Math.max(dp[map.get(keys)] + 1, max);
				}
			}
			dp[i] = max;
			result = Math.max(result, max);
			map.put(nums[i], i);
		}
		return result;
	}
}






//别人写的bianry search的做法
/*
public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
*/
