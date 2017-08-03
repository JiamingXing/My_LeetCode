package array;

public class Test {
	public static void main(String[] args) {
		NextPermutation s = new NextPermutation();
		int[] nums = new int[]{2,3,1};
		s.nextPermutation(nums);
		for (int n : nums) {
			System.out.println(n);
		}
	}
}
