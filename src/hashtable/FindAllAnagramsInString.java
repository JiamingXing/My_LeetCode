package hashtable;

import java.util.ArrayList;
import java.util.List;
//学习 别人的 sliding window的思路 有一个模板在
public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if(s == null || p == null || s.length() == 0 || p.length() == 0) {
			return res;
		}
		//首先 所有的英文字符总共是256个？ 用数组的形式代替了hash table
		int[] hash = new int[256];
		// record each character in p to hash
		for(char c : p.toCharArray()) {
			hash[c] ++;
		}
		//two pointer initialize count to p's length
		int left = 0;
		int right = 0;
		int count = p.length();
		while(right < s.length()) {
			if(hash[s.charAt(right)] >= 1) {
				count --;
			}
			hash[s.charAt(right)] --;
			right ++;
			if (count == 0) {
				res.add(left);
			}
			if (right - left == p.length()) {
				//大于等于0说明 left位置的character是属于p的之前被减掉了
				//所以我们把它加回去的同时 count也要加回去
				//如果小于0 说明本来就不属于p 只要把它加回去就可以了
				if (hash[s.charAt(left)] >= 0) {
					count ++;
				}
				hash[s.charAt(left)] ++;
				left ++;
				//保证window的长度 和count hash的值
			}
		}
		return res;
	}
}
