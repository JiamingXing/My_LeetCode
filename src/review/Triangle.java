package review;

import java.util.List;

//(x,y) -> (x+1,y) 左下   (x,y) -> (x+1, y+1) 右下
//这道题如果用递归的做法就相当于看成一个二叉树，而用DP的做法就相当于看成一个左右子树重叠的二叉树
//记忆化搜索 记忆化搜索的本质是DP  动态规划其实也不算规划，是一种思想，减少了重复计算的中间状态
//动态规划和分治的区别在于：分治算法 分的结果不会有重叠
//能够运用动态规划的题目往往是在处理的过程中，有重复的出现，互相有交集，那么我解决掉重读计算会节省时间
//动态规划尽量使用多重循环，不要使用递归的写法
//
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		//状态的定义 f[i][j]表示triangle中(i,j)这个位置走到最底层的最小路径
		//自底向上的动态规划方式
		int[] A = new int[triangle.size()+1];
	    for(int i=triangle.size()-1;i>=0;i--){
	        for(int j=0;j<triangle.get(i).size();j++){
	            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
	        }
	    }
	    return A[0];
	    
	}
}


//traverse DFS O(2^n)
/*
public class Triangle {
	int min = 0;
	public int minimumTotal(List<List<Integer>> triangle) {
		traverse(0, 0, 0, triangle);
		return min;
	}
	private void traverse(int x, int y, int sum, List<List<Integer>> triangle) {
		if (x == triangle.size()) {
			if (sum < min) {
				min = sum;
			}
		}
		traverse(x+1, y, sum+triangle.get(x).get(y), triangle);
		traverse(x+1, y+1, sum+triangle.get(x).get(y), triangle);
	}
}
*/


//divide and conquer O(2^n)
//相对于traverse 复杂度并没有降低
/*
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		return divideConquer(0, 0, triangle);
	}
	private int divideConquer(int x, int y, List<List<Integer>> triangle) {
		if (x == triangle.size()) {
			return 0;
		}
		return triangle.get(x).get(y) + Math.min(divideConquer(x+1, y, triangle), divideConquer(x+1, y+1, triangle));
	}
}
*/
