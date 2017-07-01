package geedyAlgotirhm;
//assume that you can always reach the last index
public class JumpGameII {
	public int jump(int[] nums) {
		int curReach = 0;
		if(nums.length == 1){
			return 1;
		}
		int result = 0;
		while(curReach < nums.length - 1){
			if(curReach + nums[curReach] >= nums.length - 1){
				return result + 1;
			}
			int temp = 0;
			int max = 0;
			for(int i = 1; i <= nums[curReach]; i ++){
				if(i + nums[curReach + i] > max){
					max = i + nums[curReach + i];
					temp = curReach + i;
				}
			}
			result += 1;
			curReach = temp;
		}
		return 0 ;
	}

}
