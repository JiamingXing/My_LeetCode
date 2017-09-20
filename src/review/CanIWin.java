package review;

import java.util.Arrays;
import java.util.HashMap;

/*
if we want to use a Hashmap to remember the outcome of sub-problems, 
can we just use Map<boolean[], Boolean> ? 
Obviously we cannot, because the if we use boolean[] as a key, 
the reference to boolean[] won't reveal the actual content in boolean[].
*/

public class CanIWin {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
		if (sum < desiredTotal) {
			return false;
		}
		if (desiredTotal <= 0) {
			return true;
		}
		int[] used = new int[maxChoosableInteger];
		HashMap<String, Boolean> map = new HashMap<>();
		return helper(desiredTotal, used, map);
	}
	private boolean helper(int target, int[] used, HashMap<String, Boolean> map) {
		String cur = Arrays.toString(used);
		if (map.containsKey(cur)) {
			return map.get(cur);
		}
		for (int i = 0; i < used.length; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				//赢的条件是对于target-i-1对手赢，也就是自己输
				if (target <= i+1 || !helper(target-i-1, used, map)) {
					map.put(cur, true);
					//一开始写成了1。。没有通过 为什么？
					//used[i] = 1;
					used[i] = 0;
					return true;
				}
				used[i] = 0;
			}
		}
		map.put(cur, false);
		return false;
	}
}
