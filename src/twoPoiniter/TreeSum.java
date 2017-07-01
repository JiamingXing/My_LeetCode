package twoPoiniter;
//从 3sum 4sum 联想到 Ksum 都是一个做法
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i ++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[low]);
					temp.add(nums[high]);
					result.add(temp);
					while (low < high && nums[low + 1] == nums[low]) {
						low ++;
					}
					while (low < high && nums[high - 1] == nums[high]) {
						high --;
					}
					low ++;
					high --;
				}else if (sum > 0) {
					high --;
				} else { 
					low ++;
				}
			}
		}
		return result;
	}

}




//用递归的方法做可以通过但是还是超时问题
/*
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(result, temp, nums, 0, 0);
        return result;
        
    }
    public void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int sums, int start){
        if(temp.size() == 3){
			if(sums == 0){
				result.add(new ArrayList<>(temp));
			}
			return;
		}
		for(int i = start; i < nums.length; i++){
			temp.add(nums[i]);
			helper(result, temp, nums, sums + nums[i], i+1);
			temp.remove(temp.size()-1);
			while(i < nums.length -1 && nums[i + 1] == nums[i]){
		        i ++;
			}
		}
    }
}
*/
