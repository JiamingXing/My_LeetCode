package init;
import java.util.ArrayList;
import java.util.List;

public class combinationToSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<Integer>(), 1, k, n);
        return result;
        
        
    }
	public void combination(List<List<Integer>> result, List<Integer> temp, int pos, int k, int n){
        if(temp.size() == k){
            if (n == 0) {
                List<Integer> list = new ArrayList<>(temp);
                result.add(list);
            }
            return; //return直接结束调用循环的函数！！！！！！一定要想清楚
            // 但是break还会执行循环后面的语句！！！！
        }
        for(int i = pos; i <= 9; i++){
            temp.add(i);
            combination(result, temp, i+1, k, n-i); //什么时候停止递归？？
            temp.remove(temp.size() - 1);
            
        }
    }
	
}
/*
public class Solution {
public List<List<Integer>> combinationSum3(int k, int n) {
    int[] num = {1,2,3,4,5,6,7,8,9};
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, new ArrayList<Integer>(), num, k, n,0);
    return result;
    }

public void helper(List<List<Integer>> result, List<Integer> list, int[] num, int k, int target, int start){
    if (k == 0 && target == 0){
        result.add(new ArrayList<Integer>(list));
    } else {
        for (int i = start; i < num.length && target > 0 && k >0; i++){
            list.add(num[i]);
            helper(result, list, num, k-1,target-num[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
*/
	
	
	
/*	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> ans = new ArrayList<>();
	    combination(ans, new ArrayList<Integer>(), k, 1, n);
	    return ans;
	}

	private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i+1, n-i);
			comb.remove(comb.size() - 1);
		}
	}
*/

