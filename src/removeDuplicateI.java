import java.util.Arrays;

public class removeDuplicateI {
	public int removeDuplicates(int[] nums) {
		Arrays.sort(nums);
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if(i > 1 && nums[i] == nums[i -1]){
                continue;
            }
            nums[count] = nums[i];
            count ++;
        }
        return count;
	}
}
