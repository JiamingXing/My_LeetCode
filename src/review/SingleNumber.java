package review;
//非常tricky的方法 用XOR异或 很难想到
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int n : nums) {
			result ^= n;
		}
		return result;
	}

}
