package binarySearch;
//把rotate array 形象化 这样更容易理解分类讨论的情况 
//二分法的本质就是 取mid 然后舍弃左边还是舍弃右边

//同时，如果有重复元素的rotated array  只能写for循环 O(n)

public class searchRotateArrayI {
	 public int search(int[] nums, int target) {
		 if(nums.length == 0){
	            return -1;
	        }
	        if(nums.length == 1){
	            if(nums[0] == target){
	                return 0;
	            }else{
	                return -1;
	            }
	        }
	        int start = 0;
	        int end = nums.length - 1;
	        while(start + 1 < end){
	            int mid = start + (end - start) / 2;
	            if(nums[mid] == target){
	                return mid;
	            }
	            if(nums[mid] > nums[start]){
	                if(nums[mid] >= target && target >= nums[start]){
	                    end = mid;
	                }else{
	                    start = mid;
	                }
	            }else{
	                if(nums[mid] <= target && target <= nums[end]){
	                    start = mid;
	                }else{
	                    end = mid;
	                }
	            }
	        }
	        if(nums[end] == target){
	            return end;
	        }else if(nums[start] == target){
	            return start;
	        }else{
	            return -1;
	        }
	 }

}
