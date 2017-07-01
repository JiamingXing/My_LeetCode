package init;
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
//用了Arrays.sort是不是就不是O(n)的时间复杂度了？
/*
public int thirdMax(int[] nums){
	Integer max1 = null;
	Integer max2 = null;
	Integer max3 = null;
	for(Integer n : nums){
		if(n.equals(max1) || n.equals(max2) || n.equals(max3)){
			continue;
		}
		if(max1 == null || n > max1){
			max3 = max2;
			max2 = max1;
			max1 = n;
		}else if(max2 == null || n > max2){
			max3 = max2;
			max2 = n;
		}else if(max3 == null || n > max3){
			max3 = n;
		}
	}
	return max3 = null ? max1 : max3;
}
*/
