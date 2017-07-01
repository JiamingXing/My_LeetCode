
public class maximumSubarray {
	
	public int maxSubArray(int[] nums) {
        int max =nums[0];
        int currentMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentMax = currentMax + nums[i] > nums[i] ? currentMax + nums[i] : nums[i];
            max = Math.max(max, currentMax);
        }
        return max;
        
    }

}
//max = Math.max(max, sum[i]);
//这一方法的核心思路，dynamic programming
//i 从 0到 length-1 对于每一个i 都求包括i在内的连续最大子数组
//和卖股票的问题有相似之处