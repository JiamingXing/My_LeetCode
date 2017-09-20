package review;

public class PalindromePartitionII {
	public int minCut(String s) {
		//这样的写法会超时，大题思路没问题，那么我们怎么去优化它？
		//先分析这样写DP的时间复杂度，首先这里有两重循环，那么时间复杂度为n^2
		//但是我每一次循环中都要判断从j - i这个子字符串是不是回文 也需要n的时间
		//所以整体的时间复杂度为O(n^3) 所以我怎么去优化它？
		//判断是否回文这件事可以优化吗？因为如果我要判断是否回文，如果头尾相同中间也是回文
		//那么这一段字符串是回文，所以判断回文本身也是一个可以通过DP减少重复计算的过程。
		//这种动态规划叫做区间动态规划，动态的东西是区间的长度。
		//对于这道题我们可以用一个二维boolean数组来统计从j到i是否回文
		int[] dp = new int[s.length() + 1];
		dp[0] = -1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		//这里用二维数组记录从字符串的第j个位置到第i个位置是否回文，用区间型动态规划
		//思路从九章算法学来的，不然完全没有经验去这么想
		//动态的是区间的长度所以我们要初始化区间长度为0和1的值
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			isPalindrome[i][i] = true;
		}
		for (int i = 0; i < s.length() - 1; i ++) {
			isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
		}
		for (int len = 2; len < s.length(); len ++) {
			for (int start = 0; start + len < s.length(); start ++) {
				isPalindrome[start][start + len] = isPalindrome[start+1][start+len-1] && s.charAt(start) == s.charAt(start+len);
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (isPalindrome[j][i]) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[dp.length - 1];
	}
//	private boolean isPalindrome(String s) {
//		if (s == null || s.length() == 0) {
//			return false;
//		}
//		char[] ch = s.toCharArray();
//		int start = 0;
//		int end = s.length() - 1;
//		while (start <= end) {
//			if (ch[start] != ch[end]) {
//				return false;
//			} else {
//				start ++;
//				end --;
//			}
//		}
//		return true;
//	}
}

//简化版？在循环中同时更新 但是上面的写法可能显得思路清晰一些
/*
public int minCut(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];
    
    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;  
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
}
*/
