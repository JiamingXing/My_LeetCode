package twoPoiniter;

import java.util.Arrays;

public class KDiffPairs {
	public int findPairs(int[] nums, int k){
		if (nums == null || nums.length == 0 || k < 0){
			return 0;
		}
		Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j <nums.length; j++ ){
                if(nums[j] - nums[i] > k){
                    break;
                }
                if(nums[j] - nums[i] == k){
                    result ++;
                    //第一次做的时候没在这里加break，导致[1,1,1,1,]的case
                    //没通过 以后要多注意这种特殊情况的细节case 不要无脑run
                    //相对应的还有一些初始特殊情况比如什么矩阵为空返回0，自己
                    //经常会忘了写。。希望能注意改这个习惯
                    break;
                }
            }
        }
        return result;
	}
}
//但是这道题可以用hashmap来改进方案 最直接的思路不是最快的
/*
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
*/