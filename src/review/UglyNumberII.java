package review;
//思路就是三个序列，因子分别为2，3，5然后对三个序列使用merge sort
//不是自己想到的 这道题可能去找前后关系不是很好找。
public class UglyNumberII {
	public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i =1; i < n; i++) {
        	int min = Math.min(next2, Math.min(next3, next5));
        	dp[i] = min;
        	if (next2 == min) {
        		index2 ++;
        		next2 = 2 * dp[index2];
        	}
        	if (next3 == min) {
        		index3 ++;
        		next3 = 3 * dp[index3];
        	}
        	if (next5 == min) {
        		index5 ++;
        		next5 = 5 * dp[index5];
        	}
        }
        return dp[n-1];
    }
}
