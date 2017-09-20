package review;

import java.util.ArrayList;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int sum = 0;
		int[] digits = new int[n+1];
		ArrayList<Integer> frac = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			sum *= i;
			digits[i] = sum;
			frac.add(i);
		}
		k --;
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			int index = k/digits[n-1];
			int temp = frac.get(index);
			k = k % digits[n-1];
			sb.append(temp);
			frac.remove(index);
			n --;
		}
		return sb.toString();
	}
}
