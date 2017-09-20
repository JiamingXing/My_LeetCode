package review;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
        //int[][]的意思是int[] 类型的数组 所以我只需要设置这个数组的长度
		//里面存的有多长我可以到时候再new
		int[][] pt = new int[numRows][];
		for(int i=0;i<numRows;i++){
			pt[i] = new int[i+1];
			pt[i][0] = 1;
			for(int j=1;j<i;j++){
				pt[i][j] = pt[i-1][j-1]+pt[i-1][j];
			}
			pt[i][i] =1;
		}
		for (int i = 0;i < numRows; i++){
		    List<Integer> row = new ArrayList<>();
		    for (int j : pt[i]) {
		        row.add(j);
			
		    }
		    list.add(row);
		    
		}
		
		return list;
	}
}
