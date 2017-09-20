package heap;

import java.util.PriorityQueue;
//一个priorityqueue从某一行开始poll出一个最小的之后往下走
//怎么想到这种思路的？ 时间复杂度怎么分析？
public class KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Tuple> Q = new PriorityQueue<>();
		for (int i = 0; i < (matrix.length > k ? k : matrix.length); i++) {
			Q.add(new Tuple(0, i, matrix[0][i]));
		}
		for (int i = 0; i < k-1; i++) {
			Tuple cur = Q.poll();
			if (cur.row == matrix.length - 1) {
				continue;
			}
			Q.add(new Tuple(cur.row+1, cur.col, matrix[cur.row+1][cur.col]));
		}
		return Q.poll().val;
	}
	//自己写一个implment Comparable这个接口的类
	private class Tuple implements Comparable<Tuple> {
		int row;
		int col;
		int val;
		public Tuple(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
		
		@Override
		public int compareTo(Tuple that) {
			return this.val - that.val;
		}
	}
}


//range binary search
/*
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = matrix[0][0];
        int end = matrix[m-1][n-1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            int j = n - 1;
            for (int i = 0; i < m; i ++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j --;
                }
                count += (j + 1);
            }
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
*/
