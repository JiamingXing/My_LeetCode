import java.util.ArrayList;
import java.util.List;

public class combinationSumsI {
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(result, temp, candidates, target, 0);
		return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start){
		if(target == 0){
			result.add(new ArrayList<>(temp));
			return;
		}else if(target < 0){
			return;
		}
		for(int i = start; i < nums.length; i ++){
			temp.add(nums[i]);
			helper(result, temp, nums,target - nums[i], i);
			temp.remove(temp.size()-1);
		}
		
	}


}
