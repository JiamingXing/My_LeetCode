package init;
import java.util.ArrayList;
import java.util.List;

public class permutation {
	public List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(result, temp, nums.length, nums);
		return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> temp, int l, int[] nums){
		if(l == 0){
			result.add(new ArrayList<>(temp));
		}
		for(int i = 0; i < nums.length; i++){
			if(!temp.contains(nums[i])){
				temp.add(nums[i]);
				helper(result, temp, l-1, nums);
				temp.remove(temp.size()-1);
			}
		}
		
	}

}
