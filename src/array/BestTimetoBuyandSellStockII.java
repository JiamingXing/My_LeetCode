package array;
//证明这道题可以用贪心算法解决？
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int profit = prices[i+1] - prices[i];
			if (profit > 0) {
				res += profit;
			}
		}
		return res;
	}
}
