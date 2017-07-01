package binarySearch;
//这个问题怎么转换？合适 -- find first element larger than target
//第一个大于等于target的元素 
//找第一个 >= target的位置
public class searchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		 int start = 0;
	        int end = nums.length - 1;
	        while(start + 1 < end){
	            int mid = start + (end - start) / 2;
	            if(nums[mid] >= target){
	                end = mid;
	            }else{
	                start = mid;
	            }
	        }
	        if(nums[end] >= target){
	            if(nums[start] >= target){
	                return start;
	            }else{
	                return end;
	            }
	        }else{
	            return end + 1;
	        }
	}
}
/*
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == target){
				index = i;
				return index;
			}else if(nums[i] > target){
				index = i;
				return index;
			}
			if(target > nums[nums.length-1]){
				index = nums.length;
			}
		}
		
		return index;
        
    }
}
*/

/*
 public int searchInsert(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end- start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
        
    }
    */
