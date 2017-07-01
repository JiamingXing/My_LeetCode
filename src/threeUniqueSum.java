import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeUniqueSum {
	public static void main(String[] args) {
		int[] nums = new int[]{-1, 0, 1, 2, -1, 4};
		System.out.println(threeSum(nums));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(result, temp, nums, 0, 0);
        return result;
	}
	public static void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int sums, int start){
		if(temp.size() == 3){
			if(sums == 0){
				result.add(new ArrayList<>(temp));
			}
			return;
		}
		for(int i = start; i < nums.length; i++){
			 //if(i < nums.length -1 && nums[i + 1] == nums[i]){
			 //	continue;
			 //}
			temp.add(nums[i]);
			helper(result, temp, nums, sums + nums[i], i+1);
			temp.remove(temp.size()-1);
			while(i < nums.length -1 && nums[i + 1] == nums[i]){
		        i ++;
			}
		}
	}

}
// 有不止一道题出现过类似的情况，就是重复input：[-1 0 1 2 -1 -4]
//输出的结果是[-1 -1 2] [-1 0 1] [-1 0 1]
//[-1 0 1]出现了两次，如何避免这样的情况发生？！

//另一个问题 递归的时间复杂度太高，这道题需要用two pointer
