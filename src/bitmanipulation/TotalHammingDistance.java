package bitmanipulation;

public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		int res = 0;
		int l = nums.length;
		for (int i = 0; i < 32; i ++) {
			int bitCount = 0;
			for (int j = 0; j < l; j++) {
				bitCount += (nums[j] >>> i) & 1;
			}
			res += bitCount * (l - bitCount);
		}
		return res;
	}
}
