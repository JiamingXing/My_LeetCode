package DynamicProgramming;
//什么情况使用动态规划求解？？
//求最大值最小值
//判断是否可行
//统计方案个数
//以上三种情况极有可能用动态规划求解
//求出所有的具体方案而非方案的具体个数
//输入数据是一个集合而不是序列
//很大可能不用动态规划解决

import java.util.ArrayList;

//坐标型动态规划，序列型动态规划，双序列型动态规划大部分
//划分型

//动态规划四要素
//1. 状态： 灵感创造力 存储小规模问题
//2. 方程： 状态之间的联系，怎么通过小的状态
//3. 初始化： 最极限的小状态是什么，起点
//4. 答案： 最大的那个状态是什么，重点
import java.util.List;
//这是贪心算法的思路，但是结果是错的
/*
public class triangle {
	 public int minimumTotal(List<List<Integer>> triangle) {
		 int size = triangle.size();
		 int sum = 0;
		 int temp = 0;
		 sum += triangle.get(temp).get(temp);
		 for(int i = 1; i < size; i ++){
			 temp = compare(triangle.get(i).get(temp),triangle.get(i).get(temp + 1), temp);
			 sum = sum + triangle.get(i).get(temp);
		 }
		 return sum;
	 }
	 public int compare(int a, int b, int temp){
		 if(a <= b){
			 return temp;
		 }else{
			 return temp + 1;
		 }
	 }
}
*/
//在二叉树中，有traversal和divide and conquer两种方法
//traversal以void的形式写函数
//如果用traversal解决这道题，是最暴力的方法，计算所有可能路径的sum然后取最小的一个
//时间复杂度为O(2^n)
//如果用divide and conquer 用一个hash table可以优化
//就是divide and conquer with memorization
//memorization的本质就是dynamic programming - memorization search
//dynamic programming的本质是一种思想 解决重读计算
//dynamic解决重复的问题  
//多重循环 优点：正规，存在空间优化可能性 缺点：思考有难度
//记忆化搜索 优点：容易从搜索算法直接转化过来 节省时间 缺点：递归
//还是那句话 能不用递归尽量不要用递归
//dynamic programming 和 greedy algorithm相比
//dynamic programming要考虑全局， greedy algorithm只考虑当前

//这种recursion的方法超时了。。。时间复杂度为O(h^2)?
//因为有很多重复的情况 能不能用一个hash table存储算出来的结果？
/*
public class triangle{
	public int minimumTotal(List<List<Integer>> triangle){
		return helper(triangle, 0, 0);
	}
	public int helper(List<List<Integer>> triangle, int row, int column){
		if(row == triangle.size()){
			return 0;
		}
		return triangle.get(row).get(column) + Math.min(helper(triangle, row + 1, column), helper(triangle, row+ 1, column + 1));
	}
}
*/
//二维数组这么定义好像会出问题
/*
public class triangle{
	public int minimumTotal(List<List<Integer>> triangle){
		int[][] dArray = new int[triangle.size()][];
		dArray[0][0] = triangle.get(0).get(0);
		// initialization
		for(int i = 1; i < triangle.size(); i ++){
			dArray[i][0] = dArray[i - 1][0] + triangle.get(i).get(0);
			dArray[i][i] = dArray[i - 1][i - 1] + triangle.get(i).get(i);
			
		}
		// top to down
		for(int i = 1; i < triangle.size(); i ++){
			for(int j = 1; j < i; j ++){
				dArray[i][j] = Math.min(dArray[i - 1][j], dArray[i - 1][j - 1]) + triangle.get(i).get(j);
			}
		}
		int result = 0;
		for(int k = 0; k < dArray[triangle.size()].length; k ++){
			result = Math.min(result, dArray[triangle.size()][k]);
		}
		return result;
	}
}
/*
//这么写好像把原list改掉了 不太好？
public class triangle{
	public int minimumTotal(List<List<Integer>> triangle){
		for(int i = triangle.size()-2; i >= 0; i --){
			for(int j = 0; j <= i; j ++){
				triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j));
			}
		}
		return triangle.get(0).get(0);
	}
}
*/
//学会分析时间复杂度
public class triangle{
	public int minimumTotal(List<List<Integer>> triangle){
		List<List<Integer>> result = new ArrayList<>(triangle);
		for(int i = result.size()-2; i >= 0; i --){
			for(int j = 0; j <= i; j ++){
				result.get(i).set(j, Math.min(result.get(i+1).get(j), result.get(i+1).get(j+1)) + result.get(i).get(j));
			}
		}
		return result.get(0).get(0);
	}
}




