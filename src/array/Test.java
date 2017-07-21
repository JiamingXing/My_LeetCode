package array;

public class Test {
	public static void main(String[] args) {
		MaximumSubarrayIII s = new MaximumSubarrayIII();
		int[] nums = new int[]{-1, -2, -3, -100, -1, -50};
		System.out.println(s.maxSubArray(nums, 2));
	}
}
