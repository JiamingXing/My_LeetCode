package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> temp = new ArrayList<>();
		for (int n : nums1) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int n : nums2) {
			if (map.containsKey(n) && map.get(n) > 0) {
				temp.add(n);
				map.put(n, map.get(n) - 1);
			}
		}
		int[] res = new int[temp.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = temp.get(i);
		}
		return res;
	}

}
