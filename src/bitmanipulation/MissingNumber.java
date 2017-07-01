package bitmanipulation;
//为什么？
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res ^= nums.length;
	}
}
