package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int max = 0;
		for (int key : map.keySet()) {
			if(map.containsKey(key+1)) {
				max = Math.max(max, map.get(key) + map.get(key+1));
			}
//			if(map.containsKey(key-1)) {
//				max = Math.max(max, map.get(key)+map.get(key-1));
//			}
		}
		return max;
	}
}
