package review;
//自己写的做每一行的二分 应该是比较笨的方法
public class Searcha2DMatrixII {
		public boolean searchMatrix(int[][] matrix, int target) {
	        for (int i = 0; i < matrix.length; i++) {
	            if (binarySearch(matrix, i, 0, matrix[i].length - 1, target)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    private boolean binarySearch(int[][] matrix, int row, int start, int end, int target) {
	        while (start <= end) {
	            int mid = start + (end - start) / 2;
	            int cur = matrix[row][mid];
	            if (cur == target) {
	                return true;
	            } else if (cur < target) {
	                start = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
	        return false;
	    }
	}


//从右上角开始搜索 时间复杂度O(m+n)
/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
*/
