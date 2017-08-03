package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class PermutationSequence {
//	public String getPermutation(int n, int k) {
//		int[] nums = new int[n];
//		for (int i = 0; i < n; i++) {
//			nums[i] = i+1;
//		}
//		while (k > 1) {
//			nextPermuation(nums);
//			k --;
//		}
//		StringBuilder sb = new StringBuilder();
//		for (int num : nums) {
//			sb.append(num);
//		}
//		return sb.toString();
//	}
//	private void nextPermuation(int[] nums) {
//		int n = nums.length - 2;
//		while (n >= 0 && nums[n] >= nums[n+1]) {
//			n--;
//		}
//		if (n == -1) {
//			Arrays.sort(nums);
//		} else {
//			int pos = n+1;
//			while (pos < nums.length && nums[pos] > nums[n]) {
//				pos ++;
//			}
//			pos --;
//			int temp = nums[pos];
//			nums[pos] = nums[n];
//			nums[n] = temp;
//			Arrays.sort(nums, n+1, nums.length);
//		}
//	}
//}

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		List<Integer> frac = new ArrayList<>();
		int[] dig = new int[n+1];
		dig[0] = 1;
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
			dig[i] = sum;
		}
		//{1,2,3,4}
		for (int i = 1; i <= n; i++) {
			frac.add(i);
		}
		k --;
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			int ind = k/dig[n-1];
			k = k % dig[n-1];
			int temp = frac.get(ind);
			sb.append(temp);
			frac.remove(ind);
			n--;
		}
		return sb.toString();
	}
}

