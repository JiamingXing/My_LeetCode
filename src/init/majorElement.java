package init;
public class majorElement {
	public int majorityElement(int[] nums) {
		int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
		
	}

}
//这个方法只能强行学习，想不到。。
//sort 的复杂度是nlogn 比上面的trick方法慢 但是思路直接
/*
public int majorityElement(int[] nums) {
Arrays.sort(nums);
int len = nums.length;
return nums[len/2];
}
*/