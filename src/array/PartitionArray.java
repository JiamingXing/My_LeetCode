package array;
//快排的一部分 最重要的部分
//比如sort color的题也可以用这种方法做
//快速排序不稳定

public class PartitionArray {
	public int partitionArray(int[] nums, int k) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			while (start <= end && nums[start] < k) {
				start ++;
			}
			while (start <= end && nums[end] >= k) {
				end --;
			}
			if (start <= end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
//				System.out.println(start);
//				System.out.println(end);
				start ++;
				end --;
			}
		}
		return start;
	}
}
