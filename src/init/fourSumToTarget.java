package init;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSumToTarget {
	 public List<List<Integer>> fourSum(int[] nums, int target) {
		 Arrays.sort(nums);
		 List<List<Integer>> result = new ArrayList<>();
	     List<Integer> temp = new ArrayList<>();
	     helper(result, temp, nums, target, 0);
	     return result;
	 }
	 public void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start){
		 if(temp.size() == 4){
			 
			if(target == 0){
				result.add(new ArrayList<>(temp));
			}
			return;
		}
		for(int i = start; i < nums.length; i++){
			temp.add(nums[i]);
			helper(result, temp, nums, target - nums[i], i+1);
			temp.remove(temp.size()-1);
			while(i < nums.length - 1 && nums[i + 1] == nums[i]){
			    i ++;
			}
		}
	 }

}
