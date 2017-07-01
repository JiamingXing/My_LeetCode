package bitmanipulation;
//这个一般性的思路其实不太好想
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major=nums[0];
        int count = 0;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else {
            	count--;
            }
            
        }
        return major;
        
    }
}

//Bit manipulation 
/*
public int majorityElement(int[] nums) {
 int[] bit = new int[32];
 for (int num: nums)
     for (int i=0; i<32; i++) 
         if ((num>>(31-i) & 1) == 1)
             bit[i]++;
 int ret=0;
 for (int i=0; i<32; i++) {
     bit[i]=bit[i]>nums.length/2?1:0;
     ret += bit[i]*(1<<(31-i));
 }
 return ret;
}
*/


//hash map的方法是最慢的方法
/*
public class MajorityElement {
	int max = 0;
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			max = Math.max(max, map.get(nums[i]));
		}
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				return key;
			}
		}
		return -1;
	}
}
*/



