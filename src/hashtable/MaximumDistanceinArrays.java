package hashtable;

import java.util.List;
//真的很傻比 这么简单的方法没想到 之前没有利用到升序这个条件 我每次用当前的max和min 和之前的max和min求最大值就可以了
//时间复杂度O(m)
public class MaximumDistanceinArrays {
	public int maxDistance(List<List<Integer>> arrays) {
		int res = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(res, Math.abs(max - arrays.get(i).get(0)));
            res = Math.max(res, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return res;
    }
}


//暴力解 TLE O(m^2)时间复杂度
/*
public class MaximumDistanceinArrays {
	public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int[][] minMax = new int[m][];
        for (int i = 0; i < m; i++) {
            List<Integer> list = arrays.get(i);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int n : list) {
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
            minMax[i] = new int[2];
            minMax[i][0] = min;
            minMax[i][1] = max;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int curMin = minMax[i][0];
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    continue;
                }
                int curMax = minMax[j][1];
                res = Math.max(res, Math.abs(curMax - curMin));
            }
        }
        return res;
    }
}
*/
