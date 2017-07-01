package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//[0,0,0,0]的case就没通过 为什么？
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length -3; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j ++) {
				if (j > 0 && nums[j] == nums[j-1]) {
					continue;
				}
				int low = j + 1; 
				int high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if (sum == target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
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
					}else if (sum < target) {
						low ++;
					}else {
						high --;
					}
				}
			}
		}
		return result;
		
	}

}




//自己写的backtracking 不过有部分case存在超时
//所以需要用hash map
/*
public class Solution {
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
*/