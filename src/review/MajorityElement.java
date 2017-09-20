package review;

//bit manipulation
public class MajorityElement {
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
}


//Moore Voting algorithm
/*
public class MajorityElementI {
	public int majorityElement(int[] nums) {
		int major=nums[0];
        int count = 0;
        for(int i=0; i<nums.length;i++){
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
*/