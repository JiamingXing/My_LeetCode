package review;
//错误的思路
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		int insertPos = 1;
		for (int i = 1; i < nums.length; i ++) {
			int curCount = 1;
			while (i > 0 && i < nums.length && nums[i] == nums[i-1]) {
				curCount ++;
				i ++;
				if (curCount <= 2) {
					nums[insertPos++] = nums[i-1];
				}
			}
		}
		return insertPos;
	}
}

/*
public class Solution {
    public int removeDuplicates(int[] nums) {
        int insertPos = 0;
		for(int n : nums){
			if(i < 2 || n > nums[insertPos - 2]){
				nums[insertPos++] = n;
			}
		}
		return insertPos;
        
    }
}
*/
