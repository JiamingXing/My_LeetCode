package init;
import java.util.ArrayList;
import java.util.List;

public class subsetsDistinct {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(result, temp, nums, 0);
		return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
		result.add(new ArrayList<>(temp));
		for(int i = start; i < nums.length; i++){
			temp.add(nums[i]);
			helper(result, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}

}
//思路最初的构思是怎样的？
//怎么设置递归终止条件？