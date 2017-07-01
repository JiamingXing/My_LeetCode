package array;
//without division and O(n)
//这是别人的思路 很难想到 有点错位相乘的意思？ 很巧妙的思路
public class ProductArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		int temp = 1;
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] *= temp;
			temp *= nums[i];
		}
		return res;
	}
}
