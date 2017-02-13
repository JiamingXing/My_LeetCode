import java.util.Arrays;

public class findThirdMax {
	public static void main(String[] args) {
		int nums[] = new int[]{3,3,4,3,4,3,0,3,3};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(thirdMax(nums));
		
	}
	 public static int thirdMax(int[] nums) {
		 int temp[] = new int[3];
		 int j =0;
		 for(int i=nums.length-1;i>0;i--){
			 if(nums[i]==nums[i-1]& j<3){
				 temp[j] = nums[i];
			 }else{
				 temp[j] = nums[i];
				 j++;
				 temp[j] = nums[i-1];
				 if(j ==2){
					 break;
				 }
			 }
		 }
		 if(j==2){
			 return temp[2];
		 }else{
			 return temp[0];
		 }
		 
	 }

}
