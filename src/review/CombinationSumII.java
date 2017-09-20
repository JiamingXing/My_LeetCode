package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, candidates, target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int pos) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        if (target < 0 || pos >= candidates.length) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
        	//同一层元素 我们通过判断跳过 避免重复
            if (i > pos && candidates[i] == candidates[i-1]) {
                continue;
            }
            temp.add(candidates[i]);
            //每个元素最多只能使用一次 但是不同的元素对应相同值可以各自使用一次
            helper(res, temp, candidates, target - candidates[i], i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
