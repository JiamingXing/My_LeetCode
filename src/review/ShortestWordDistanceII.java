package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
	Map<String, List<Integer>> map = new HashMap<>();
	public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i ++) {
            String cur = words[i];
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(i);
        }
    }
	
	public int shortest(String word1, String word2) {
//        int min = Integer.MAX_VALUE;
//        for (int p1 : map.get(word1)) {
//            for (int p2 : map.get(word2)) {
//                min = Math.min(min, Math.abs(p1 - p2));
//            }
//        }
//        return min;
		//用  pointer变成O(m+n)
		int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if (index1 < index2) {
                min = Math.min(min, index2 - index1);
                i ++;
            } else {
                min = Math.min(min, index1 - index2);
                j ++;
            }
        }
        return min;
    }
}
