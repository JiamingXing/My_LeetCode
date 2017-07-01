package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int[] temp = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			temp[nums[i]] ++;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 2) {
				res.add(i);
			}
		}
		return res;
	}
}
