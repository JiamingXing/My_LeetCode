package array;

public class SortColor {
	public void sortColors(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		//先排用partition array的思想 把0都归到左边 大于0都到右边
		while (start <= end) {
			while (start <= end && nums[start] == 0) {
				start ++;
			}
			while (start <= end && nums[end] > 0) {
				end --;
			}
			if (start <= end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start ++;
				end --;
			}
		}
		//再用同样的方法排一
		end = nums.length - 1;
		while (start <= end) {
			while (start <= end && nums[start] == 1) {
				start ++;
			}
			while (start <= end && nums[end] > 1) {
				end --;
			}
			if (start <= end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start ++;
				end --;
			}
		}
	}
}
