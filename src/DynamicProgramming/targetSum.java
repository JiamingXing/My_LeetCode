package DynamicProgramming;
//这道题可以转换成存在多少种可能挑选部分和等于(sum(nums) + target)/2
public class targetSum {
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for(int n : nums){
			sum += n;
		}
		return sum < S ||(S+sum) % 2 == 0 ? subset(nums, (S+sum)/2) : 0;
	}
	//这种做法是怎么想到的。。。求所有可能组合加起来等于target？
	//如何保证所有可能都考虑到的。。。。。。？
	//这道题转换成为给你一个数组，每个元素只能用一次求所有可能的组合加起来等于target
	//这样转换之后如何想到用DP来做？？符合DP的哪个特征
	//时间复杂度为O(n*(target-n))
	public int subset(int[] nums, int target){
		int[] temp = new int[target+1];
		//第一步的初始化0很关键 这样可以用来定义所有nums上数据对应的位置
		temp[0] = 1;
		for(int n:nums){
			for(int i = target; i >= n; i --){
				temp[i] += temp[i-n];
			}
		}
		return temp[target];
	}

}
