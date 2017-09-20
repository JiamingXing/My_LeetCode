package review;
//有点利用到bucket sort的思想 把元素的值和index联系在一起
//因为我们只关心first missing positive，所以负数我们直接跳过
//遍历数组每个元素放到它应该放的位置(值减一的index)
//最后我们再遍历数组从0开始 每个位置都应该等于对应的index+1 如果不是就是我们要找的first missing positive
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == i+1 || nums[i] < 0 || nums[i] > nums.length) {
				continue;
			} else if (nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i]-1);
			} else {
				i ++;
			}
		}
		i = 0;
		while (i < nums.length && nums[i] == i+1) {
			i ++;
		}
		return i+1;
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
