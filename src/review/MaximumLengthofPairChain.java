package review;

import java.util.Arrays;

//这道题不是自己做出来的 这个arrays sort这个是调用的什么？
//这道题类似于interval scheduling的问题 和merge interval也有点类似
//但是merge interval是直接把头尾分别sort 然后不断merge就OK
public class MaximumLengthofPairChain {
	public int findLongestChain(int[][] pairs) {
		//根据每一行的第二个数进行排序
		Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
	    int sum = 0, n = pairs.length, i = -1;
	    while (++i < n) {
	        sum++;
	        int curEnd = pairs[i][1];
	        //找第一个开始比当前结束要大的pair
	        //整体思路应该是贪心算法？
	        while (i+1 < n && pairs[i+1][0] <= curEnd) {
	        	i++;
	        }
	    }
	    return sum;
	}
}
