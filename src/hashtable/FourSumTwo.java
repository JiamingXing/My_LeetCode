package hashtable;

import java.util.HashMap;
import java.util.Map;
//hashmap有一个操作 map.getOrDefault(key,value)可以简化if语句
public class FourSumTwo {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map1 = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (map1.containsKey(A[i] + B[j])) {
					map1.put(A[i] + B[j], map1.get(A[i] + B[j]) + 1);
				} else {
					map1.put(A[i] + B[j], 1);
				}
			}
		}
		int result = 0;
		for (int i = 0; i < C.length; i++) {
			for(int j = 0; j < D.length; j++) {
			    int temp = C[i] + D[j];
			    if(map1.containsKey(-temp)) {
			    	result += map1.get(-temp);
			    }
			}
		}
		return result;
	}
	//写了一种复杂度为O(n^2) 的算法
	//为什么和答案只是计算ABCD的顺序 不同但是结果会不一样？？？？
}


/*
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
    
    for(int i=0; i<C.length; i++) {
        for(int j=0; j<D.length; j++) {
            int sum = C[i] + D[j];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }
    
    int res=0;
    for(int i=0; i<A.length; i++) {
        for(int j=0; j<B.length; j++) {
            res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
        }
    }
    
    return res;
    }
}
*/
