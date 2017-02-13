import java.util.HashSet;
import java.util.Set;

public class containsDuplicateII {
	public static void main(String[] args) {
		int nums[] = new int[]{99,99};
		if(containsNearbyDuplicate(nums,2)){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
		
	}
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }

}
// hashset怎么用的？
// hashset中有很多boolean类型的method
// !set.add(nums[i]) ???