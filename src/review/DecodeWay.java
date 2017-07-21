package review;

public class DecodeWay {
	public int numDecodings(String s) {
		int len = s.length();
		if (s == null || len == 0) {
			return 0;
		}
		//state : dp[i]表示到位置i共有多少decode ways
		int[] dp = new int[len+1];
		//初始化 dp[0]定义成1就用一个简单的12的例子分析一下
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= len; i++) {
			//function由当前位置和它的前一位决定
			int first = Integer.valueOf(s.substring(i-1, i));
			int second = Integer.valueOf(s.substring(i-2, i));
			if(first >= 1 && first <= 9){
				dp[i] = dp[i-1];
			}
			if(second >= 10 && second <= 26){
				dp[i] += dp[i-2];
			}
		}
		return dp[len];
	}
}
