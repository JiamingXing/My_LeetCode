import java.util.Arrays;
//还原rotate array： 三步翻转法 O(n) O(1)的额外空间 reverse
//[4 5 1 2 3]
//[4 5 1 2 3] -> [5 4 1 2 3] -> [5 4 3 2 1] -> [1 2 3 4 5]
/*for(int i = 0, j = n - 1; i < j; i++, j++){
	t = A[i];
	A[i] = A[j];
	A[j] = t;
}
*/

public class rotateArray {
	public static void main(String[] args) {
		int nums[] = new int[]{1,2,3,4,5,6,7};
		rotate(nums,3);
		System.out.println(Arrays.toString(nums));
		
	}
	public static void rotate(int[] nums, int k) {
	    k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
	}
	// rotate函数中要调用reverse函数 reverse函数要写static吗？？

	public static void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}

}
//这是时间最快空间最小的方法，可是怎么形成这样rotate的思路？
//最简单的思路 bubble rotate 时间最长O(n*k)
//一直有个问题 如果在主函数下面直接写调用函数验证，一定要写static吗？涉及static的概念