package DynamicProgramming;
//有O(n) space
public class NumArray {
	 int[] nums;
	 public NumArray(int[] nums) {
		 this.nums = nums;
		 for(int l = 1; l < nums.length; l ++){
	           nums[l] = nums[l-1] + nums[l]; 
	        }
	 }
	 public int sumRange(int i, int j) {
		 if(i == 0){
			 return nums[j];
		 }else{
			 return nums[j] - nums[i -1];
		 }
	 }

}
//这道题可以很好的体现出DP的本质是减少重复运算 降低时间复杂度

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */


//下面是我最初自己写的版本，本质上没什么区别，多了O(n)的space 但是超时了
//我新建了一个result在函数SumRange里,所以我每计算一次i j 都要调用一次sumRange
//也要重新计算一次result 以及新分配一次地址 所以不可行！！！
/*
public class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int l = 1; l < result.length; l ++){
           result[l] = result[l-1] + nums[l]; 
        }
        if(i == 0){
            return result[j];
        }else{
            return result[j] - result[i -1];
        }
    }
}
*/
