package DynamicProgramming;
//坐标类型的题
//dynamic programming的问题 如何设计状态和进行初始化时比较难的
//初始化第一行和第一列是为了编程方便，后面不用进行判断来初始化
//以后初始化一个二维的动态规划的时候，就去初始化第一行和第一列！
public class findMinPathSum {
	public int minPathSum(int[][] grid) {
		int numRow = grid.length;
		int numCol = grid[0].length;
		int[][] sum = new int[numRow][numCol];
		//initialization origin
		sum[0][0] = grid[0][0];
		for(int i = 1; i < numCol; i ++){
			sum[0][i] = sum[0][i - 1] + grid[0][i];
		}
		for(int j = 1; j < numRow; j ++){
			sum[j][0] = sum[j - 1][0] + grid[j][0];
		}
		for(int m = 1; m < numCol; m ++){
			for(int n = 1; n < numRow; n ++){
				sum[n][m] = Math.min(sum[n][m - 1], sum[n - 1][m]) + grid[n][m]; 
			}
		}
		return sum[numRow - 1][numCol - 1];
	}
}
//这是我接触的第二道DP的题
//前提是告诉你用DP
//自己思考总结一下 什么样的类似的题可以让你想到用DP
//还有解决一道DP问题的关键四步骤到底是如何构思最好！


//但是这不是最优的解法 还可以继续优化空间复杂度

