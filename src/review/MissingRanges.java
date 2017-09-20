package review;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
        for (int n : nums) {
            int low = n - 1;
            if (lower == low) {
                res.add("" + lower);
            } else if (lower < low) {
                res.add("" + lower + "->" + low);
            }
            lower = n + 1;
        }
        if (lower == upper) {
            res.add("" + upper);
        } else if (lower < upper) {
            res.add("" + lower + "->" + upper);
        }
        return res;
	}
}
