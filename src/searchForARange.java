
public class searchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
        if(nums.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != target){
                continue;
            }
            result[0] = i;
            while(i < nums.length - 1 && nums[i + 1] == nums[i]){
                i ++;
            }
            result[1] = i;
            return result;
        }
        if(result[0] == 0 && result[1] == 0){
                result[0] = -1;
                result[1] = -1;
            }
        return result;
	}

}

// binary search的方法会更快一点？ 如果写binary search
