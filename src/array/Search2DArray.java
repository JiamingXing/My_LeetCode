package array;
//还是太复杂了
public class Search2DArray {
	public boolean searchMatrix(int[][] matrix, int target) {
//		int[] temp = new int[matrix.length];
//		for (int i = 0; i < temp.length; i++) {
//			temp[i] = matrix[i][0];
//		}
//		int row = matrix.length - 1;
//		for (int i = 0; i < temp.length; i++) {
//			if (temp[i] > target) {
//				row = i-1;
//				break;
//			} else if (temp[i] == target) {
//				return true;
//			}
//		}
//		for (int i = 0; i < matrix[row].length; i++) {
//			if (matrix[row][i] == target) {
//				return true;
//			} else if (matrix[row][i] > target) {
//				break;
//			}
//		}
//		return false;
		if (matrix == null || matrix.length == 0) {
            return false;
        }
		int i = 0;
		int j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
}
