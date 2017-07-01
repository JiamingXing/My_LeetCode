package DynamicProgramming;
//还是要先将问题进行一定的转换
public class onesAndZeros {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		for(String s : strs){
			int[] count = countNum(s);
			//不需要initialization？
//			dp[count[0]][count[1]] ++;
			//state function怎么想出来的？？
			for(int i = m; i >= count[0]; i--){
				for(int j = n; j >= count[1]; j--){
					dp[i][j] = Math.max(dp[i][j], 1 + dp[i-count[0]][j-count[1]]); 
				}
			}
		}
		return dp[m][n];
	}
	public int[] countNum(String s){
		int[] result = new int[2];
		int length = s.length();
		for(int i = 0; i < length; i ++){
			if(s.charAt(i) == '0'){
				result[0] ++;
			}else{
				result[1] ++;
			}
		}
		return result;
	}

}
