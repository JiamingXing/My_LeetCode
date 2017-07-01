package review;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i ++) {
			for (int j = 0; j < B.length; j ++) {
				int temp = A[i] + B[j];
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
		}
		int res = 0;
		for (int i = 0; i < C.length; i ++) {
			for (int j = 0; j < D.length; j++) {
				int temp = C[i] + D[j];
				res += map.getOrDefault(-temp, 0);
			}
		}
		return res;
	}
}
