package hashtable;

import java.util.HashMap;
import java.util.Map;

//contiguous and equal number of '0''1' in binary array
//这道题做第二遍还是没想到这个思路
public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		for(int i = 0; i< nums.length; i++) {
			if(nums[i] == 0) {
				nums[i] = -1;
			}
		}
		int sum = 0;
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for(int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if(map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return max;
	}
}
//学习一下这道题的思路，是怎么转换的 当然如果前提做过maximum size subarray sum k
//可能思路会容易形成
//我遍历数组 计算从头到current position的sum
//如果 之前有这个sum 那么说明我之前sum所到达的位置到我现在位置这一段的和应该是0
//也就是满足题目要求的contiguous subarray
//那么我一直取最大就可以找出最长的哪一个
//因为我不拘泥于0这一个sum 所有我能找出所有子数组的情况
//而且也有一个隐藏条件 就是我一旦再碰到之前的sum 我并不更新i的位置 因为我要找最长的
//好好体会一下这种思路 是怎么通过一个问题的分析转换来的 
//如果你实现不知道这题用hash table来做 你能想到这样的做法吗？