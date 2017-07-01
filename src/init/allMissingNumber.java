package init;

public class allMissingNumber {
	public static void main(String[] args) {
		int nums[] = new int[]{0,1,3};
		System.out.println(missingNumber(nums));
		
	}
	
	
	public static int missingNumber(int[] nums) {
		int test[] = new int[nums.length+1];
		for(int i=0;i<nums.length;i++){
			test[nums[i]]++;
		}
		int j =0;
		// 为什么我不在这里定义j在for里定义j不可以把j作为返回值？？？？？
		for(j = 0;j<test.length;j++){
			if (test[j]==0){
				//return j;
				break;
			}
		}
		return j ;
		
	}

}

/* better solution? use Xor operation
 * public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
	for (i = 0; i < nums.length; i++) {
		xor = xor ^ i ^ nums[i];
	}

	return xor ^ i;
} */

/* another better silution
 * public static int missingNumber(int[] nums) {
    int sum = nums.length;
    for (int i = 0; i < nums.length; i++)
        sum += i - nums[i];
    return sum;
} 
*/
