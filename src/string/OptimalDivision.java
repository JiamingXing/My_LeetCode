package string;
//这道题和next greater差不多 medium的题要先自己想出思路
//再用编程语言表达出来 自己想一些特殊的case 让代码避免特殊情况 思维的严密性
//比如这题我需要找到一个特殊的case 和正常思维不同
public class OptimalDivision {
	public String optimalDivision(int[] nums) {
		//largest is always the first element?
		int largest = nums[0];
		
		//find smallest of the rest part
		StringBuilder sb = new StringBuilder();
		sb.append(largest);
		for (int i  = 1; i < nums.length; i++) {
			if (i == 1 && nums.length > 2) {
				sb.append("/(").append(nums[i]);
			} else {
				sb.append("/").append(nums[i]);
			}
		}
		return nums.length > 2 ? sb.append(")").toString() : sb.toString();
	}

}
