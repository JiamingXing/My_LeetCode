import java.util.Arrays;

public class twoSumSpecificNumber {
	public static void main(String[] args) {
		int numbers[] = new int[]{2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(numbers,target)));
		
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int result[] = new int[2];
		for(int i=0;i<numbers.length;i++){
			int j = numbers.length-1;
			while(numbers[i]+numbers[j]>target &&j>i){
				j--;
			}
			if(numbers[i]+numbers[j]==target){
				result[0] =i+1;
				result[1] = j+1;
				return result;
				// break；
				}
			
		}
		// 虽然if下面返回了但是切记for循环如果在if下的语句都无法返回的情况下就无法返回
		// 这样是不行的 所以必须
		return result;
		
	}

}
