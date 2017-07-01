package DynamicProgramming;
//DP的本质是减少重复运算
//最蠢的思路肯定是 从第一个元素开始然后一直考虑所有的continuous sum 
//如果存在mod k ==0 返回true 中间是不是有很多重复的加法操作？
//但是如果开辟一个新的array存储从第一个开始一直到第i个元素的和
//然后验证他们之间的差会不会减少很多复杂度？？？
public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums.length < 2){
            return false;
        }
		//要考虑k = 0的情况
        if(k == 0){
            for(int l = 0; l < nums.length - 1; l ++){
                if(nums[l] ==0 && nums[l+1] == 0){
                    return true;
                }else{
                    return false;
                }
            }
        }
        int[] test = new int[nums.length];
        test[0] = nums[0];
        //initialization
        for(int i = 1; i < test.length; i ++){
            test[i] = test[i-1] + nums[i];
            if(test[i] % k == 0){
                return true;
            }
        }
        for(int m = 0; m < test.length - 2; m ++){
            for(int n = m + 2; n < test.length; n ++){
                if((test[n] - test[m]) % k == 0){
                    return true;
                }
            }
        }
        return false;
	}
}

//最粗暴直接的做法 比上面的DP慢
//因为里面有不少重复加法运算
/*
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2){
            return false;
        }
		//要考虑k = 0的情况
        if(k == 0){
            for(int l = 0; l < nums.length - 1; l ++){
                if(nums[l] ==0 && nums[l+1] == 0){
                    return true;
                }else{
                    return false;
                }
            }
        }
        
        for(int m = 0; m < nums.length - 1; m ++){
            int sum = nums[m];
            for(int n = m + 1; n < nums.length; n ++){
                sum += nums[n];
                if(sum % k == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
*/


//用hash map
//对map不熟悉还没看懂这个程序的意思。。
/*
public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
    int runningSum = 0;
    for (int i=0;i<nums.length;i++) {
        runningSum += nums[i];
        if (k != 0) runningSum %= k; 
        Integer prev = map.get(runningSum);
        if (prev != null) {
            if (i - prev > 1) return true;
        }
        else map.put(runningSum, i);
    }
    return false;
}
*/
