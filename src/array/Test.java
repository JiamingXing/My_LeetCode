package array;

public class Test {
	public static void main(String[] args) {
		PartitionArray s = new PartitionArray();
		int[] nums = new int[]{6,4};
		s.partitionArray(nums, 4);
		System.out.println(s.partitionArray(nums, 4));
	}
}
