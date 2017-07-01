public class twoSumInSortedArray {
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while(start < end){
            if(numbers[start] + numbers[end] == target){
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }else if(numbers[start] + numbers[end] > target){
                end --;
            }else{
                start ++;
            }
        }
        return result;
	}

}
//这道题也可以用binary search来写 但是复杂度更高
// 可以尝试一下
