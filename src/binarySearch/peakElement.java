package binarySearch;
//为什么这道题可以想到用二分法去做？
//first/last position of xxx
//去掉一定没有结果的部分（一半）/保留一定有结果的部分

public class peakElement {
	public int findPeakElement(int[] nums) {
		int start = 0;
        int end = nums.length - 1;
        if(start == end){
            return start;
        }
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }else{
                start = mid;
            }
        }
        //这么写的好处是只考虑 start和end两个指针的情况 容易写出return
        if(nums[start] > nums[end]){
            return start;
        }else{
            return end;
        }
	}

}
