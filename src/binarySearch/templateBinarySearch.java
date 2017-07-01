package binarySearch;
//写binary search的模板 不会出现死循环
//1. start + 1 < end
//2.start + (end - start) /2
//3.A[mid] ==, <, >
//4.A[start] A[end] ? target

public class templateBinarySearch {
	public int binarySearch(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		//循环结束的条件是两个指针相邻或者重叠
		while(start + 1 < end){
			int mid = start + (end - start) / 2;//避免溢出
			if(nums[mid] == target){
				end = mid;
				//找first position
				//如果找last position
				//改成 start = mid;
			}else if(nums[mid] < target){
				//不用管替换指针是不是 mid + 1 都用mid
				start = mid;
			}else{
				end = mid;
			}
		}
		if(nums[start] == target){
			return start;
		}
		if(nums[end] == target){
			return end;
		}
		return -1;
	}

}
//一般是怎么出现死循环的？

