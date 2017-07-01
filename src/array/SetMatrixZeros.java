package array;

public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
		int label = 1;
		for(int i = 0; i< matrix.length; i ++){
			//用第一列来记录
			if(matrix[i][0] == 0){
                label = 0;
            }
            for(int j = 1; j < matrix[i].length; j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = matrix.length - 1; i >= 0; i --){
            for(int j = matrix[i].length - 1; j >= 1; j --){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(label == 0){
               matrix[i][0] = 0; 
            }
        }
	}
}
