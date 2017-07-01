package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixI {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                res.add(matrix[rowStart][i]); //change
            }
            rowStart ++;
            
            for (int i = rowStart; i <= rowEnd; i ++) {
                res.add(matrix[i][colEnd]); //change
            }
            colEnd --;
            
            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    res.add(matrix[rowEnd][i]); //change
            }
            rowEnd --;
            
            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    res.add(matrix[i][colStart]); //change
            }
            colStart ++;
        }
        return res;
	}
}
