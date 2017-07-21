package review;
//给出一个integer的数组，你最初定位在数组的第一个位置上，数组中的每个元素代表
//你在这个位置最多可以跳跃的最大长度，判断能否到达数组的最后一个位置
//这道题可以用DP和贪心算法两种方法解决 贪心算法的时间复杂度为O(n) DP为O(n^2)
public class JumpGame {
	public boolean canJump(int[] A) {
		//DP
		boolean[] dp = new boolean[A.length];
		dp[0] = true;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && j+A[j] >= i) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[A.length - 1];
	}
}

//greedy
//public class JumpGame {
//	public boolean canJump(int[] A) {
//		int i = 0;
//		while (i < A.length) {
//			if (i + A[i] >= A.length - 1) {
//				return true;
//			}
//			int max = 0;
//			int temp = i;
//			for (int j = i+1; j <= i+A[i] && j < A.length; i++) {
//				if (j + A[j] > max) {
//					max = j + A[j];
//					temp = j;
//				}
//			}
//			i = temp;
//		}
//		return false;
//		if (A == null || A.length == 0) {
//            return false;
//        }
//        int farthest = A[0];
//        for (int i = 1; i < A.length; i++) {
//            if (i <= farthest && A[i] + i >= farthest) {
//                farthest = A[i] + i;
//            }
//        }
//        return farthest >= A.length - 1;
//	}
//}



