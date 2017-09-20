package DynamicProgramming;

import java.util.Stack;
//可以从valid parentheses那道题拿到点思路吗利用stack 然后就是怎么想到往stack里放integer
//一开始这道题自己想着是用区间型动态规划来做
//其实也可以用DP做 但是一开始想的区间型动态规划，是因为思路只放在一种case上，就是我两头分别是
//'('')'但是肯定不对，我们可以用单序列型动态规划来做

/*
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		//DP的思路
		if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int n = s.length();
        int max = 0;
        //dp[i]表示包含第i个字符的最长valid parenthesis长度
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 0) + 2;
                    max = Math.max(max, dp[i]);
                    // s.charAt(i-2) == ')'
                } else {
                    int left = i - dp[i-1] - 1;
                    if (left >= 0 && s.charAt(left) == '(') {
                        dp[i] = dp[i-1] + 2 + ((left - 1) >= 0 ? dp[left-1] : 0);
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        return max;
	}
}
*/


public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		//多余的')'的位置
		int left = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				//之前没有'('此时的')'属于无法配对的 那么我们更新left
				if (stack.isEmpty()) {
					left = i;
				} else {
					//取出配对的'('如果这时stack空了匹配长度就等于此时坐标到最后一个
					//没法配对的')'的坐标长度
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - left);
					} else {
						//如果没空我们同时计算到最远'('无法配对的距离
						//配对的'('已经被pop掉了
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}
		return max;
	}
}



