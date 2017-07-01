import java.util.Arrays;

public class moveAllZeros {
	public static void main(String[] args) {
		int nums[] = new int[]{0,1,0,3,12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
	}
	public static void moveZeroes(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
//自己一开始的想法
/*public static void moveZeroes(int[] nums) {
	for(int i =0;i<nums.length-1;i++){
		int j = i+1;
		if(nums[i] == 0){
			while(nums[j]==0 && j<nums.length-1){
				j++;
			}
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			
		}
	}
        
        
    }*/

}
