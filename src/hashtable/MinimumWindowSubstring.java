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
					//这里用right - left + 1太容易无解了
					//因为right满足条件之后会自动++所以我区间的长度应该是right -left
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

//正确的版本
/*
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        //这个array 应该是int的不是char的！卡在这里debug了2个小时！
        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c] ++;
        }
        int left = 0;
        int right = 0;
        int head = 0;
        int min = Integer.MAX_VALUE;
        int count = t.length();
        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count --;
            }
            hash[s.charAt(right)] --;
            right ++;
            if (count == 0) {
                while (count == 0) {
                    //count = 0 说明这个区间包含t的所有characters 这个时候移动left找最小区间
                    if (right - left < min) {
                        min = right - left;
                        head = left;
                    }
                    //如果hash[s.charAt(left)] == 0说明这个时候移动left count要增加了
                    //即将推出count = 0的内置循环 要重新移动right
                    if (hash[s.charAt(left)] == 0) {
                        count ++;
                    }
                    hash[s.charAt(left)] ++;
                    left ++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }
}
*/


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
