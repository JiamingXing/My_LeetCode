package review;
//这道题看了答案做出来的 不是很应该 我感觉很典型的动态规划问题，不应该分析不出来
//有一步原因可能被需要你把具体的lds return，所以有点犹豫，想去用backtracking做
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Arrays.sort(nums);
		//state : dp[i]表示包含第i个位置元素最长lds
		int[] dp = new int[nums.length];
		//需要一个数组记录最长情况对应之前的index 如果记录-1表示自身就是头
		//我可以通过这个数组的index信息进行记录我整个lds
		//所有元素所对应的index 在最后把他放入list中
		int[] ind = new int[nums.length];
		//需要一个max来记录最长的情况 同时记录对应的index
		int max = 0;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			//initialize
			dp[i] = 1;
			ind[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						ind[i] = j;
					}
				}
			}
			if (dp[i] > max) {
				max = dp[i];
				index = i;
			}
		}
		while (index != -1) {
			res.add(nums[index]);
			index = ind[index];
		}
		return res;
	}
}
