
public class arraySearchInsert {
	public static void main(String[] args) {
		int nums[] = new int[]{1,3,5,6};
		int target = 7;
		System.out.println(searchInsert(nums,target));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int index = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == target){
				index = i;
				return index;
			}else if(nums[i] > target){
				index = i;
				return index;
			}
			if(target > nums[nums.length-1]){
				index = nums.length;
			}
		}
		
		return index;
    }

}
// 这是最笨的方法 想一想二叉树的方法？
/*
 * public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
*/
