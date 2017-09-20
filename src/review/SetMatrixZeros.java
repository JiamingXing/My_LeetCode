package review;

public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
		int label = 1;
		//怎么想到用matrix的第一列作为label 为什么需要
		//因为我们会用第一行和第一列来记录对应的行列是否变成0 会改变原来数组的值
		//我们只要单独记录第一列是否变0就可以使整个算法可行
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				label = 0;
			}
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
				if (label == 0) {
					matrix[i][0] = 0;
				}
			}
		}
	}
}
