package init;
import java.util.Arrays;

public class sortColorsThree {
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,2,9,9,1,4,7,6,8};
		//int[] nums = new int[]{1,0,1};
		quickSort(nums, 0, nums.length-1);
		//如果不写成static的话，必须先实例化之后才可以调用
		//Arrays.sort() 静态我在任何地方可以直接调用。
		System.out.println(Arrays.toString(nums));
	}
	public static void quickSort(int[] nums, int lowerIndex, int higherIndex){
		int i = lowerIndex;
		int j = higherIndex;
		//int pivot = nums[lowerIndex+(higherIndex-lowerIndex)/2];
		int pivot = nums[lowerIndex];
		while(i <= j){
			while(nums[i] < pivot){
				i ++;
			}
			while(nums[j] > pivot){
				j--;
			}
			if(i <= j){
				swap(nums, i, j);
				i ++;
				j --;
			}
		}
		if(lowerIndex < j){
			quickSort(nums, lowerIndex, j);
		}
		if(i < higherIndex){
			quickSort(nums, i, higherIndex);
		}
	}
	public static void swap(int[] nums, int k, int l){
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
	}

}
