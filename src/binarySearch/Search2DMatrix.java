package binarySearch;
//因为这个二维数组是递增的本质就和一维数组一样，我们只要找到对应横纵坐标关系就可以用二分搜索做
//时间复杂度O(log(m*n))
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m * n - 1;
		while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[start/n][start%n] == target) {
        	return true;
        } else if (matrix[end/n][end%n] == target) {
        	return true;
        } else {
        	return false;
        }
 	}
}

/*
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m * n - 1;
		while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
*/
