


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class printPasacalTrianglexRow {
	public static void main(String[] args) {
		int rowIndex = 4;
		System.out.println(Arrays.toString(getRow(rowIndex).toArray()));
	}
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		int[][] pt = new int[rowIndex+1][];
		for(int i=0;i<rowIndex+1;i++){
			pt[i] = new int[i+1];
			pt[i][0] = 1;
			for(int j=1;j<i;j++){
				pt[i][j] = pt[i-1][j-1]+pt[i-1][j];
			}
			pt[i][i] =1;
		}
		for (int i : pt[pt.length - 1]) {
			list.add(i);
		}
		return list;
	}

}

