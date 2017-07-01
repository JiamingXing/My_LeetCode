package hashtable;
// two pointer, String, sliding window
//最初自己写的版本，没有通过，纯粹根据范例的test case写出来的代码
//没有考虑很多特殊的test case
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
			return "";
		}
		int[] hash = new int[256];
		//record each character in t
		for (char c : t.toCharArray()) {
			hash[c] ++;
		}
		// two pointer
		int left = 0;
		int right = 0;
		//一开始没有想到要加一个head
		int head = 0;
		int count = t.length();
		//也没有考虑到要记录最小长度
		int min = Integer.MAX_VALUE;
		while (right < s.length()) {
			if (hash[s.charAt(right)] >= 1) {
				count --;
			}
			hash[s.charAt(right)] --;
			right ++;
			//record window length
			if (count == 0) {
				while (count == 0) {
					if (right - left + 1 < min) {
						min = right - left + 1;
						head = left;
					}
					if (hash[s.charAt(left)] >= 0) {
						count ++;
					}
					hash[s.charAt(left)] ++;
					left ++;
				}
			}
		}
		//长度如果没有变化 返回"" 处理比较特殊的case
		//substring不仔细想 很容易出错 end的index会差1
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head+min-1);
	}
}




//最初自己写的版本，没有通过，纯粹根据范例的test case写出来的代码
//没有考虑很多特殊的test case
/*
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
			return null;
		}
		int[] hash = new int[256];
		//record each character in t
		for (char c : t.toCharArray()) {
			hash[c] ++;
		}
		// two pointer
		int left = 0;
		int right = 0;
		int count = t.length();
//		int min = Integer.MAX_VALUE;
		while (right < s.length()) {
			if (hash[s.charAt(right)] >= 1) {
				count --;
			}
			hash[s.charAt(right)] --;
			right ++;
			//record window length
			if (count == 0) {
				while (count == 0) {
					if (hash[s.charAt(left)] >= 0) {
						count ++;
					}
					hash[s.charAt(left)] ++;
					left ++;
				}
//				min = Math.min(min, right - left + 1);
			}
		}
		return s.substring(left-1, right);
	}
}
*/
