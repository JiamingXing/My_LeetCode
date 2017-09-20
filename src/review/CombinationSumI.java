package review;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, candidates, target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int pos) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            temp.add(candidates[i]);
            //这里的position不是i+1而是当前的i，因为我们可以重复使用里面的元素
            helper(res, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
