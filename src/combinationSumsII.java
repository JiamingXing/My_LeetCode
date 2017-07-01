import java.util.ArrayList;
import java.util.List;

public class combinationSumsII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(result, temp, candidates, target, 0);
		return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start){
		if(target == 0){
			result.add(new ArrayList<>(temp));
		}else if(target < 0){
			return;
		}
		for(int i = start; i < nums.length; i++){
			if(i > start && nums[i] == nums[i-1]){
				continue; 
				// skip duplicates
			}
			temp.add(nums[i]);
			helper(result, temp, nums, target - nums[i], i+1);
			temp.remove(temp.size()-1);
		}
	}

}

/*
public List<List<Integer>> combinationSum2(int[] cand, int target) {
Arrays.sort(cand);
List<List<Integer>> res = new ArrayList<List<Integer>>();
List<Integer> path = new ArrayList<Integer>();
dfs_com(cand, 0, target, path, res);
return res;
}
void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
if (target == 0) {
    res.add(new ArrayList(path));
    return ;
}
if (target < 0) return;
for (int i = cur; i < cand.length; i++){
    if (i > cur && cand[i] == cand[i-1]) continue;
    path.add(path.size(), cand[i]);
    dfs_com(cand, i+1, target - cand[i], path, res);
    path.remove(path.size()-1);
}
}
*/