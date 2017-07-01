package binarySearch;
//转换为 数组中第一个小于num[num.length - 1]的位置
// first position <= last number;
// 如果有重复的数怎么办？？ 如果有重复的就无法使用二分法，只能用O（n）的方法

public class findMinRotated {
	public int findMin(int[] nums) {
		if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        //while(start <= end){
        while(start < end){
            mid = (start + end) >>> 1;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[mid] > nums[end] && nums[mid] >= nums[start]){
                start = mid + 1;
            }else{
                end = end - 1;
            }
        }
        return nums[start];
        // return nums[mid];
	}

}
//两种不同的边界条件一样的结果。
//做binary search的关键在于先想清楚我不断取中间点有哪几种判断情况
//难点在于写边界条件 >= <= > <试试几个世纪例子
//如果有test跑不过 想想所有可能的情况 进行修改 
