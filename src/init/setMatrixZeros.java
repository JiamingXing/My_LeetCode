package init;
//这道题很关键的一点是如何不丢失信息 在逐一搜索0的过程如果in place的存储0的位置
//而且很关键的 第0列用一个label表示 而不用[i][j]来判断
public class setMatrixZeros {
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

