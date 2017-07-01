package DynamicProgramming;
//绝大部分的求方案总数的问题一般都用动态规划来做！
public class findUniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] result = new int[m][n];
		//initialization of first row and column
        for(int i = 0; i < n; i ++){
            result[0][i] = 1;
        }
        for(int j = 1; j < m; j ++){
            result[j][0] = 1;
        }
        for(int k = 1; k < m; k ++){
            for(int l = 1; l < n; l ++){
                result[k][l] = result[k][l-1] + result[k-1][l];
            }
        }
        return result[m-1][n-1];
	}

}
