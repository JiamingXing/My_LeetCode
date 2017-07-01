package twoPoiniter;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionArrayII {
	 public int[] intersect(int[] nums1, int[] nums2) {
		 ArrayList<Integer> temp = new ArrayList<>();
		 Arrays.sort(nums1);
		 Arrays.sort(nums2);
		 int  i = 0;
		 int j = 0;
		 while(i < nums1.length && j <nums2.length){
			 if(nums1[i] < nums2[j]){
				 i++;
			 }else if(nums1[i] > nums2[j]){
				 j++;
			 }else{
				 temp.add(nums1[i]);
				 i++;
				 j++;
			 }
		 }
		 int[] result = new int[temp.size()];
		 for(int k = 0; k < temp.size(); k++){
			 result[k] = temp.get(k);
		 }
		 return result;
		 
	 }
}
