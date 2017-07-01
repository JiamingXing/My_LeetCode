package DynamicProgramming;
//问你几种方案，容易想到用DP
//坐标性DP
public class climbStair {
	public int climbStairs(int n) {
		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		for(int i = 2; i <= n; i ++){
			result[i] = result[i-1] + result[i-2];
		}
		return result[n];
	}

}
