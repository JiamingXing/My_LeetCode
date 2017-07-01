package array;
//Boyer-Moore Majority Vote Algorithm
//分为四步走：
//初始化 如果要找大于1/k的元素，那么我们需要两个k-1长度的数组
//第一步 先在candidate数组中找是否有和当前元素相等的candidate，如果找到我给这个count加一 continue
//第二步 如果找不到相同的candidate，找第一个是0的元素，是0的话就更新对应的candidate为当前num 并且count加一
//第三步 如果当前所有candidate对应的count都不为0，那么全都减一
//第四步已经找到最多的candidate，我们把他们的count归0，重新遍历数组，进行计数，判断计数是否满足标准，满足的就是我们想要的结果。
import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<Integer> res = new ArrayList<>();
		int num1 = nums[0];
		int num2 = nums[0];
		int count1 = 0;
		int count2 = 0;
		int len = nums.length;
		// find the most two elements
		for (int n : nums) {
			if (n == num1) {
				count1 ++;
			} else if (n == num2) {
				count2 ++;
			} else if (count1 == 0) {
				num1 = n;
				count1 ++;
			} else if (count2 == 0) {
				num2 = n;
				count2 ++;
			} else {
				count1 --;
				count2 --;
			}
		}
		//initialize to 0 to count exact number of these two elements
		count1 = 0;
		count2 = 0;
		for (int n : nums) {
			if (n == num1) {
				count1 ++;
			} else if (n == num2) {
				count2 ++;
			}
		}
		if (count1 > len / 3) {
			res.add(num1);
		}
		if (count2 > len / 3) {
			res.add(num2);
		}
		return res;
	}
}


//Boyer-Moore Majority Vote Algorithm template
/*
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, k = 3;  //in this question, k=3 specifically
        List<Integer> result = new ArrayList<Integer>();
        if (n==0 || k<2) return result;
        int[] candidates = new int[k-1];
        int[] counts = new int[k-1];
        for (int num: nums) {
            boolean settled = false;
            //如果可以找到相同的candidate 那么对应的count++ 同时会跳过下面的步骤
            for (int i=0; i<k-1; i++) {
                if (candidates[i]==num) {
                    counts[i]++;
                    settled = true;
                    break;
                } 
            }
            if (settled) continue;
            //如果没有找到相同的candidate 找到第一个count为0的index
            //设置对应的candidate为当前的值，并给count ++
            for (int i=0; i<k-1; i++) {
                if (counts[i]==0) {
                    counts[i] = 1;
                    candidates[i] = num;
                    settled = true;
                    break;
                } 
            }
            if (settled) continue;
            //如果之前所有的candidate count都不为0，也就是都大于0 那我们所有的都-1
            for (int i=0; i<k-1; i++) counts[i] = (counts[i] > 0) ? (counts[i]-1) : 0;
        }
        Arrays.fill(counts, 0);
        for (int num: nums) {
            for (int i=0;i<k-1; i++) {
                if (candidates[i]==num) {
                    counts[i]++;
                    break;
                }
            }
        }
        for (int i=0; i<k-1; i++) if (counts[i]>n/k) result.add(candidates[i]);
        return result;
    }
}
*/
