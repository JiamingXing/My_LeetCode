package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoArraysI {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
			while (i < nums1.length - 1 && nums1[i+1] == nums1[i]) {
				i++;
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				list.add(nums2[i]);
			}
			while (i < nums2.length - 1 && nums2[i+1] == nums2[i]) {
				i ++;
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
