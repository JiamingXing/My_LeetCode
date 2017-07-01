
public class minimumLengthSubarray {
	public int minSubArrayLen(int s, int[] nums){
		int resultLength = nums.length + 1;
        for(int i = 0; i < nums.length; i ++){
            int j = i;
            int sums = 0;
            int temp = 0;
            while(j < nums.length && sums < s){
                sums = sums + nums[j];
                j ++;
            }
            if(j == nums.length && sums < s){
                continue;
            }
            temp = j - i;
            resultLength = resultLength < temp? resultLength:temp;
        }
        if(resultLength > nums.length){
            return 0;
        }else{
            return resultLength;
        }
	}

}
//复杂度将近 n^2的算法 有没有更快的？


/*
 //这样的想法很不实际，首先array里没有这个找最大元素下标的函数，而且最大元素可能不止一个
 
public class Solution {
public int minSubArrayLen(int s, int[] nums) {
    int sums0 = 0;
    for(int count : nums){
        sums0 = sums0 + count;
    }
    if(sums0 < s){
        return 0;
    }
    int i = findMaxIndex(nums);
    int sums1 = 0;
    int j = i;
    while(j < nums.length && sums1 < s){
        sums1 = sums1 + nums[i];
        i ++;
    }
    int temp = j - i;
    int sums2 = 0;
    while(k > -1 && sums2 < s){
        sums2 = sums2 + nums[k];
        k --;
    }
    int temp2 = i - k;
    int result = temp1 < temp2 ? temp1:temp2;
}
}
*/