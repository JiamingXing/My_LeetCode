package review;
//这道题如果可以用extra space的话我们只要找到左边变换的一一对应关系就OK
//但是如果要in place的做 该如何搞？

//如果是顺时针90度
//先tranpose(i,j) -> (j,i)
//再从做到右按列flip(swap)
public class RotateImage {
	public void rotate(int[][] matrix) {
		for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
	}
}
//如果是逆时针转90度的话
//我们就先transpose(i,j) ->  (j,i)
//然后从顶到下按行 flip翻转(swap)