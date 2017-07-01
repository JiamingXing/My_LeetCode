package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findIntersectionI {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> temp = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                while(i + 1 < nums1.length && nums1[i + 1] == nums1[i]){
                    i ++;
                }
                i ++;
            }else if(nums2[j] < nums1[i]){
                while(j + 1 < nums2.length && nums2[j + 1] == nums2[j]){
                    j ++;
                }
                j ++;
            }else{
                temp.add(nums1[i]);
                while(i + 1 < nums1.length && nums1[i + 1] == nums1[i]){
                    i ++;
                }
                i ++;
                while(j + 1 < nums2.length && nums2[j + 1] == nums2[j]){
                    j ++;
                }
                j ++;
            }
        }
        int[] result = new int[temp.size()];
        int k = 0;
        for (Integer num : temp) {
            result[k++] = num;
        }
        return result;
	}

}

//two pointer的想法 先sort 然后比较大小 一样的就输出 然后同时改变pointer
//如果一个比一个小，改变小的pointer
//写的更直观的如下 不需要考虑跳过重复元素 
/*
* public int[] intersection(int[] nums1, int[] nums2) {
     Set<Integer> set = new HashSet<>();
     Arrays.sort(nums1);
     Arrays.sort(nums2);
     int i = 0;
     int j = 0;
     while (i < nums1.length && j < nums2.length) {
         if (nums1[i] < nums2[j]) {
             i++;
         } else if (nums1[i] > nums2[j]) {
             j++;
         } else {
             set.add(nums1[i]);
             i++;
             j++;
         }
     }
     int[] result = new int[set.size()];
     int k = 0;
     for (Integer num : set) {
         result[k++] = num;
     }
     return result;
 }
 */

//考虑binary search的思路：
/*
public int[] intersection(int[] nums1, int[] nums2) {
     Set<Integer> temp = new HashSet<>();
     Arrays.sort(nums1);
     for(int i = 0; i < nums2.length; i ++){
         if(binarySearch(nums1, nums2[i])){
             temp.add(nums2[i]);
         }
     }
     int[] result = new int[temp.size()];
     int k = 0;
     for(Integer num : temp){
         result[k] = num;
         k ++;
     }
     return result;
 }
 public boolean binarySearch(int[] nums, int target){
     int start = 0;
     int end = nums.length - 1;
     int mid = 0;
     while(start <= end){
         mid = (start + end) >>> 1;
         if(nums[mid] == target){
             return true;
         }else if(nums[mid] > target){
             end = mid - 1;
         }else{
             start = mid + 1;
         }
     }
     return false;
 }
 */

