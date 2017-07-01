package init;
import java.util.ArrayList;
import java.util.List;

public class findAllNumersDisappeared {
	public static void main(String[] args) {
		int nums[] = new int[]{4,3,2,7,8,2,3,1};
		//Arrays.sort(nums);
		//System.out.println(nums); 直接打印nums不行
		//System.out.println(Arrays.toString(nums));
		System.out.println(findDisappearedNumbers(nums));
		//System.out.println(Arrays.toString(findDisappearedNumbers(nums).toArray()));
		
	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        int temp[] = new int[nums.length];
        List<Integer> l = new ArrayList<Integer>();
        //Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
        	temp[nums[i]-1] = nums[i];
              
        }
        for(int j =0;j<temp.length;j++){
        	if(temp[j]==0){
        		l.add(j+1);
        	}
        }
        return l;
            
        
    }

}
