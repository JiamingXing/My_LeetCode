package backtracking;

import java.util.ArrayList;
import java.util.List;

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
