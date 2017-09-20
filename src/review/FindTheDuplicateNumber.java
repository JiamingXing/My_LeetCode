package review;
//binary search怎么做呢？
public class FindTheDuplicateNumber {
	//这些边界条件有点搞不清楚。。
	//这么写还是不对因为 题目没有说每个元素都会有一个。。
	//比如[2,2,2,2,2]的case就过不了
	//所以我不应该统计区间里的个数而是统计整个数组中小于当前pivot的个数
	public int findDuplicate(int[] nums) {
		int start = 1;
		int end = nums.length - 1; // end = n
		while (start < end) {
			int mid = start + (end - start) / 2;
			int count = 0;
			for (int n : nums) {
				if (n <= mid && n >= start) {
					count ++;
				}
			}
			if (count == mid - start + 1) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}


//AC版本
/*
class Solution {
    public int findDuplicate(int[] nums) {
        int start = 1;
		int end = nums.length - 1; // end = n
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int count = 0;
			for (int n : nums) {
				if (n <= mid) {
					count ++;
				}
			}
			if (count <= mid) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
    }
}
*/

//binary search怎么做呢？
//这道题的思路有点像bucket sort 把原数组中的值作为新数组的index
/*
public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int res = 0;
		int[] temp = new int[nums.length - 1];
		for (int i = 0; i < nums.length; i++) {
			temp[nums[i]-1] ++;
		}
		for (int j = 0; j < temp.length; j ++) {
			if (temp[j] > 1) {
				res = j + 1;
				break;
			}
		}
		return res;
	}
}
*/