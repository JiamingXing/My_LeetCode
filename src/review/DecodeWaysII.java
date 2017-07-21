package review;
//关键在于先用long来存数据 处理完了再转成int
public class DecodeWaysII {
	public int numDecodings(String s) {
		int len = s.length();
		if (s == null || len == 0) {
			return 0;
		}
		long[] dp = new long[len+1];
		dp[0] = 1;
		if (s.charAt(0) == '0') {
			dp[1] = 0;
		} else if (s.charAt(0) == '*') {
			dp[1] = 9;
		} else {
			dp[1] = 1;
		}
		for (int i = 2; i <= len; i++) {
			if (s.charAt(i-1) == '*') {
				dp[i] = dp[i-1] * 9;
			} else if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9') {
				dp[i] = dp[i-1];
			}
			if (s.charAt(i-2) != '*' && s.charAt(i-1) != '*') {
				int temp = Integer.valueOf(s.substring(i-2, i));
				if(temp >= 10 && temp <= 26){
					dp[i] += dp[i-2];
				}
			} else if (s.charAt(i-2) == '*' && s.charAt(i-1) == '*') {
				//10-26
				dp[i] += dp[i-2] * 15;
			} else if (s.charAt(i-2) == '*') {
				if (s.charAt(i-1) > '6' && s.charAt(i-1) <= '9') {
					dp[i] += dp[i-2];
				} else {
					dp[i] += dp[i-2] * 2;
				}
			} else {
				if (s.charAt(i-2) == '1') {
					dp[i] += dp[i-2] * 9;
				} else if (s.charAt(i-2) == '2') {
					dp[i] += dp[i-2] * 6;
				}
			}
			dp[i] = dp[i] % 1000000007;
		}
		return (int)dp[len];
	}
}

//正确的版本 数据处理的问题？
/*
public class Solution {
    public static int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        if(s.length() < 2) return (int)res[0];

        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
            res[0] = temp;
        }
        return  (int)res[1];
    }
    
    private static int ways(int ch) {
        if(ch == '*') return 9;
        if(ch == '0') return 0;
        return 1;
    }

    private static int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 15;
        } else if(ch1 == '*') {
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            else
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                return 6;
            } 
        }
        return 0;
    }
}
*/
