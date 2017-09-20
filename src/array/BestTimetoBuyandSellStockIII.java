package array;
//buy at most 2 times 想到利用分割线的方法
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		//先创建差值数组 转换为maximum subarray为问题
		int[] difs = new int[prices.length - 1];
		for (int i = 0; i < prices.length - 1; i++) {
			difs[i] = prices[i+1] - prices[i];
		}
		int res = 0;
		//if transaction once
		int oneMax = Integer.MIN_VALUE;
		int sum = 0;
		int minSum = 0;
		for (int i = 0; i < difs.length; i++) {
			sum += difs[i];
			oneMax = Math.max(oneMax, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		//只能做一次交易的情况
		if (difs.length < 2) {
			return oneMax > 0 ? oneMax : 0;
		}
		//if transaction twice
		int[] left = new int[difs.length];
		int[] right = new int[difs.length];
		sum = 0;
		minSum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < left.length; i++) {
			sum += difs[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
			left[i] = max;
		}
		sum = 0;
		minSum = 0;
		max = Integer.MIN_VALUE;
		for (int i = right.length - 1; i >= 0; i--) {
			sum += difs[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
			right[i] = max;
		}
		int twoMax = Integer.MIN_VALUE;
		for (int i = 0; i < left.length - 1; i++) {
			twoMax = Math.max(twoMax, left[i] + right[i+1]);
		}
		res = Math.max(twoMax, oneMax);
		return res > 0 ? res : 0;
	}
}

/*
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right;
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        //DP from right to left;
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            profit = Math.max(left[i] + right[i], profit);  
        }

        return profit;
    }
}
*/

/*
class Solution {

    
    private int update(int a, int b, int delta) {
        if (b == Integer.MIN_VALUE) {
            return a;
        }
        
        if (b + delta > a) {
            return b + delta;
        }
        
        return a;
    } 
     
    public int maxProfit(int[] prices) {
        int K = 2;
        int n = prices.length;
        int i, j, k;
        
        int[][] f = new int[n+1][2*K+1+1];
        for (i = 0; i <= n; ++i) {
            for (j = 1; j <= 2*K+1; ++j) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        
        f[0][1] = 0;
        for (i = 1; i <= n; ++i) {
            for (j = 1; j <= 2 * K + 1; j += 2) {
                f[i][j] = update(f[i][j], f[i-1][j], 0);
                if (j > 1 && i > 1) f[i][j] = update(f[i][j], f[i - 1][j - 1], prices[i - 1] - prices[i - 2]);
            }
            
            for (j = 2; j <= 2 * K; j += 2) {
                if (i > 1) f[i][j] = update(f[i][j], f[i-1][j], prices[i - 1] - prices[i - 2]);
                if (j > 1) f[i][j] = update(f[i][j], f[i-1][j-1], 0);
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (j = 1; j <= 2 * K + 1; j += 2) {
            res = update(res, f[n][j], 0);
        }
        
        return res;
    }
}
*/

