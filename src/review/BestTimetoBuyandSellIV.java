package review;

public class BestTimetoBuyandSellIV {
	public int maxProfit(int k, int[] prices) {
		int n = prices.length - 1;
		if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int[] profit = new int[prices.length - 1];
		for (int i = 1; i <= n; i++) {
			profit[i-1] = prices[i] - prices[i-1];
		}
		int[][] local = new int[n+1][k+1];
		int[][] global = new int[n+1][k+1];
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= k; j++) {
				local[i][j] = Math.max(local[i-1][j], global[i-1][j]) + profit[i-1];
				if (i == j) {
					global[i][j] = local[i][j];
				} else {
					global[i][j] = Math.max(global[i-1][j], local[i][j]);
				}
			}
		}
		return global[n][k];
	}
}


/*
public class BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
	}
	private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
*/
