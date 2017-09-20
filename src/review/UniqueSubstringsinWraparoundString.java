package review;

public class UniqueSubstringsinWraparoundString {
	public int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0) {
            return 0;
        }
		//值需要记录以当前字符结尾的最长substring
		int[] ch = new int[26];
		int curMax = 0;
		for (int i = 0; i < p.length(); i++) {
			if (i > 0 && (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i-1) - p.charAt(i) == 25)) {
				curMax ++;
			} else {
				curMax = 1;
			}
			ch[p.charAt(i) - 'a'] = Math.max(curMax, ch[p.charAt(i) - 'a']);
		}
		int res = 0;
		for (int i = 0; i < 26; i++) {
			res += ch[i];
		}
		return res;
	}
}

//一开始自己想的DP思路但是不知道如何处理重复
//这里就需要一个很巧妙的思路 就是以某个特定字符结尾的所有子字符串的数量就等于以这个字符结尾
//的最长子字符串的长度
/*
public class UniqueSubstringsinWraparoundString {
	public int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0) {
            return 0;
        }
		//state: dp[i] 以第i位字符结尾的substring方案个数
		//怎么保证计算的所有case都是unique的？
		int[] dp = new int[p.length()];
		int[] cha = new int[26];
		cha[p.charAt(0)- 'a'] = 1;
		dp[0] = 0;
		for (int i = 1; i < p.length(); i++) {
			cha[p.charAt(i) - 'a'] = 1;
			if (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i-1) - p.charAt(i) == 25) {
				dp[i] = dp[i-1]+1;
			} else {
				dp[i] = 0;
			}
		}
		int res = 0;
		for (int i = 0; i < p.length(); i++) {
			res += dp[i];
		}
		for (int i = 0; i < 26; i++) {
			res += cha[i];
		}
		return res;
	}
}
*/
