package DynamicProgramming;
//先想到一种不是DP的解法：
//trick 在于如果碰到比sell小的点就把这个点定位sell
//但是最终的profit用一个变量做运算
/*
public class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i ++){
            profit = Math.max(prices[i] - prices[start], profit);
            if(prices[i] < prices[start]){
                start = i;
            }
        }
        return profit;
    }
}
*/

public class SellStockI {
	public int maxProfit(int[] prices) {
		
	}

}


/*
//最初自己写的程序，最后一个case超时 时间复杂度为O(n^2)
public class Solution {
    public int maxProfit(int[] prices) {
        int[] test = new int[prices.length];
        for(int i = 0; i < test.length - 1; i ++){
            int max = 0;
            for(int j = i + 1; j < test.length; j ++){
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
            test[i] = max;
        }
        int result = 0;
        for(int l = 0; l < test.length; l ++){
            result = Math.max(result, test[l]);
        }
        return result;
    }
}
*/
