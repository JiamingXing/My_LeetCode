package array;
//相当于转换成最大连续子数字求解
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int min = prices[0];
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, prices[i] - min > 0 ? prices[i] - min : 0);
			min = Math.min(min, prices[i]);
		}
		return max;
	}
}


//直接求解
/*
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
		}
		return max;
    }
}
*/