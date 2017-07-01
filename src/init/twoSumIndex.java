package init;
import java.util.HashMap;
import java.util.Map;

public class twoSumIndex {
	
	
	
	
	
	
	
	
	
	
	
	
	public int[] twoSum(int[] nums, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        if (map.containsKey(target - nums[i])) {
	            result[1] = i ;
	            result[0] = map.get(target - nums[i]);
	            return result;
	        }
	        map.put(nums[i], i );
	    }
	    return result;
	}

}


//对于一个hashmap来说，我们定义什么是key，在这道题中，我们定义nums[i]为key
//key mapped to a specific value
//put(key,value) get(key),return value
// Interface Map 如果通过一个interface定义一个class
