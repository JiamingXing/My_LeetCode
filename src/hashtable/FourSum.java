package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
        	//跳过一些不必要的运算
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) {
                break;
            }
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target) {
                continue;
            }
            //跳过重复
            while (i > 0 && i < nums.length - 3 && nums[i] == nums[i-1]) {
                i ++;
            }
            for (int j = i+1; j < nums.length - 2; j++) {
            	//跳过不必要的运算
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) {
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target) {
                    continue;
                }
                //跳过重复
                while (j > i+1 && j < nums.length - 2 && nums[j] == nums[j-1]) {
                    j ++;
                }
                int start = j+1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    List<Integer> temp = new ArrayList<>();
                    if (sum == target) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        res.add(temp);
                        while (start < nums.length - 1 && nums[start+1] == nums[start]) {
                            start ++;
                        }
                        while (end > j+1 && nums[end - 1] == nums[end]) {
                            end --;
                        }
                        start ++;
                        end --;
                    } else if (sum > target) {
                        end --;
                    } else {
                        start ++;
                    }
                }
            }
        }
        return res;
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