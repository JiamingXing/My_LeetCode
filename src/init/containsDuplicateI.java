package init;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicateI {
	public boolean containsDuplicate(int[] nums) {
		final Set<Integer> distinct = new HashSet<Integer>();
	    for(int num : nums) {
	        if(distinct.contains(num)) { //如果已经有这个元素直接返回true
	            return true;
	        }
	        distinct.add(num); //如果是第一遍碰到某个元素，上面的if肯定不成功
	    }                      //那么把这个元素加到set中
	    return false;
	}

}
// for(int num:nums) 和 for(int i =0; i <nums.length; i++)
// 两种写法的区别


/*  一种直观的方法，排序之后前后比较相等就返回true
 * public boolean containsDuplicate(int[] nums) {


Arrays.sort(nums);
for(int ind = 1; ind < nums.length; ind++) {
    if(nums[ind] == nums[ind - 1]) {
        return true;
    }
}
return false;
} */