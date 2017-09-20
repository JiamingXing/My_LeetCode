package review;
//follow up: improve time complexity from O(n^2) to O(nlogn)
//从n^2到nlogn能想到的是二分法
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int res = 1;
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] >= nums[i]) {
					continue;
				}
				dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			res = Math.max(res, dp[i]);
		}
		return res;
		//O(nlogn) 别人的做法 根本想不到
//		int[] dp = new int[nums.length];
//        int len = 0;
//
//        for(int x : nums) {
//            int i = Arrays.binarySearch(dp, 0, len, x);
//            if(i < 0) i = -(i + 1);
//            dp[i] = x;
//            if(i == len) len++;
//        }
//
//        return len;
	}
}
