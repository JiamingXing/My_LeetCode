package DynamicProgramming;
//关键在于理解题意
//题目意思是对于每一个post 我们最多只能有一个相邻的颜色相同
//那么我对于每一个post 我都分为两种情况 一种是相同，就是前面不同的case
//一种是不同，那么我就是前面不同和相同所有的case 乘以k-1
public class PaintFence {
	public int numWays(int n, int k) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
		int dif = k * (k-1);
		int same = k;
		for (int i = 2; i < n; i++) {
			int temp = dif;
			dif = (same + dif) * (k-1);
			same = temp;
		}
		return dif + same;
	}
}
