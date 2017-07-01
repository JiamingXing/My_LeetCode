package array;

public class BestTimetoBuyandSellStock {
	int min;
	int max;
	public int maxProfit(int[] prices) {
		min = prices[0];
		max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, prices[i] - min > 0 ? prices[i] - min : 0);
			min = Math.min(min, prices[i]);
		}
		return max;
	}
}
