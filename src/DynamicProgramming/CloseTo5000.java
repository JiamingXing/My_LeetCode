package DynamicProgramming;

public class CloseTo5000 {
	public int closeMost(int[] nums) {
		int n = nums.length;
        //dp[i][j]表示从数组的前i个元素能否取到和为j的情况
        boolean[][] dp = new boolean[n+1][5001];
        int max = 0;
        //initialize初始化
        for (int i = 0; i <= n; i++) {
            //前i个数取和为0必然可以
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 5000; j >= nums[i-1]; j--) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                if (dp[i][j]) {
                    max = Math.max(max, j);
                }
            }
        }
        return max;
	}
}
