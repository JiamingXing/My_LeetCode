package init;
import java.util.ArrayList;
import java.util.List;
// 写的是连续子数组。。。。 [1 2 3] [1 3]也是子数组。。
public class subsetsDup {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(result, temp, nums, 0);
		return result;
	}
	public void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
		if(!result.contains(temp)){
			result.add(new ArrayList<>(temp));
		}
		for(int i = start; i < nums.length; i++){
			temp.add(nums[i]);
			helper(result, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
}

/*      最佳答案：
 * public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> each = new ArrayList<>();
    helper(res, each, 0, nums);
    return res;
}
public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
    if (pos <= n.length) {
        res.add(each);
    }
    int i = pos;
    while (i < n.length) {
        each.add(n[i]);
        helper(res, new ArrayList<>(each), i + 1, n);
        each.remove(each.size() - 1);
        i++;
        while (i < n.length && n[i] == n[i - 1]) {i++;}
        //这一部为了避免重复的出现，比如22234，会出现重复的22子数组；
        //这个规避重复的做法是怎么想出来的？如果用contains 时间复杂度会大大提高；
    }
    return;
}
*/


//写的是连续子数组。。。。 [1 2 3] [1 3]也是子数组。。
	/*
	 public List<List<Integer>> subsetsWithDup(int[] nums) {
		 List<List<Integer>> result = new ArrayList<>();
		 result.add(new ArrayList<>());
		 helper(result, nums, 0 );
		 return result;
	 }	
	 public void helper(List<List<Integer>> result, int[] nums, int p){
		 if(p >= nums.length){
			 return;
		 }
		 for(int i = p; i < nums.length; i++){
			 List<Integer> temp = new ArrayList<>();
			 for(int j = p; j <= i; j++){
				 temp.add(nums[j]);
			 }
			 if(!result.contains(temp)){
				 result.add(temp);
			 }
			 helper(result, nums, i+1);
		 }
	 }
	 */
