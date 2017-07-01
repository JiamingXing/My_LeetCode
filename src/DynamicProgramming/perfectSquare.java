package DynamicProgramming;
//感觉这道题和coin change差不多。。 放在一起思考一下
//这种思路比较直接 但是很慢
public class perfectSquare {
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j * j <= i; j ++){
				if(j == 1){
					dp[i] = dp[i -j*j] + 1;
				}else{
					dp[i] = Math.min(dp[i], dp[i-j*j]+1);
				}
			}
		}
		return dp[n];
	}        
}
