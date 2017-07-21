package review;
//prefix sum的思路就是最大连续子数组就等于到当前的sum 减去之前最小的sum
public class MaximumSubarrayI {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int minSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}
}


//不用全局变量会快很多
/*
public static int maxSubArray(int[] A) {
  int maxSoFar=A[0], maxEndingHere=A[0];
  for (int i=1;i<A.length;++i){
  	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
  	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
  }
  return maxSoFar;
}
*/



/*
public class MaximumSubarray {
	int max;
	public int maxSubArray(int[] nums) {
		int cur = nums[0];
		max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			cur = Math.max(cur + nums[i], nums[i]);
			max = Math.max(max, cur);
		}
		return max;
	}
}
*/