package backtracking;
//review的时候没想到每次递归应该只从当前位置开始往后递归 而不是从0开始
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
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
            helper(res, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
