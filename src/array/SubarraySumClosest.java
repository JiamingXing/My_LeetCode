package array;
//find a subarray with sum closest to zero, return their index as first number and last number
//我求完prefixsum之后进行排序 他们之间差越小就越接近0，用hashtable记录index return
//follow up : closest to K
//需要掌握的如何sort一个带index的array
public class SubarraySumClosest {
	public int[] subarraySumClosest(int[] nums) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1) {
			res[0] = 0;
			res[1] = 0;
			return res;
		}
		
	}
}
