package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {
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
//更快的方法
/*
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> temp = new ArrayList<>();
		 Arrays.sort(nums1);
		 Arrays.sort(nums2);
		 int  i = 0;
		 int j = 0;
		 while(i < nums1.length && j <nums2.length){
			 if(nums1[i] < nums2[j]){
				 i++;
			 }else if(nums1[i] > nums2[j]){
				 j++;
			 }else{
				 temp.add(nums1[i]);
				 i++;
				 j++;
			 }
		 }
		 int[] result = new int[temp.size()];
		 for(int k = 0; k < temp.size(); k++){
			 result[k] = temp.get(k);
		 }
		 return result;
    }
}
*/
