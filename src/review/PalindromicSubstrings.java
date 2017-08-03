package review;
//O(n^2)
public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res ++;
			int left = i-1;
			int right = i + 1;
			while (left >= 0 && right < s.length()) {
				if (s.charAt(left) == s.charAt(right)) {
					res ++;
					left --;
					right ++;
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			int j = i+1;
			if (s.charAt(i) == s.charAt(j)) {
				res ++;
				int left = i - 1;
				int right = j + 1;
				while (left >= 0 && right < s.length()) {
					if (s.charAt(left) == s.charAt(right)) {
						res ++;
						left --;
						right ++;
					} else {
						break;
					}
				}
			}
		}
		return res;
	}
}

/*
public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int n = s.length();
		//state dp[i][j]表示第i个字符到第j个字符的区间是否palindromic
		boolean[][] dp = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		for (int i = 0; i < n-1; i++) {
			dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
		}
		for (int len = 2; len < n; len ++) {
			for (int start = 0; start+len < n; start ++) {
				dp[start][start+len] = dp[start+1][start+len-1] && s.charAt(start) == s.charAt(start+len);
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (dp[i][j]) {
					res ++;
				}
			}
		}
		return res;
	}
}
*/
/*
public class Solution {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}
*/
