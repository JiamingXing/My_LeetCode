package sort;

public class Test {
	public static void main(String[] args) {
		int[] nums = new int[]{2};
		//int[] nums = new int[]{2,4,2,3,5,9,6};
		QuickSort s = new QuickSort();
		s.quickSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
//		System.out.println(nums[1]);
	}
}
