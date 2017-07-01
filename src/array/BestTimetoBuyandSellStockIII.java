package array;
//buy at most 2 times 想到利用分割线的方法
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
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
