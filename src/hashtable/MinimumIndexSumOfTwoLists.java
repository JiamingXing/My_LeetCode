package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
//		Map<String, Integer> map2 = new HashMap<>();
		for(int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		int min = Integer.MAX_VALUE;
		List<String> list = new ArrayList<>();
		for (int j = 0; j < list2.length; j++) {
			String s = list2[j];
			if (map.containsKey(s)) {
				int temp = j + map.get(s);
				//list.clear()  <-> list = new ArrayList<>();
				if (temp < min) {
					min = temp;
					list.clear();
					list.add(s);
				} else if (temp == min) {
					list.add(s);
				}
			}
		}
		String[] res = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
//思路相同，代码更简洁
/*
public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i=0;i<list1.length;i++) map.put(list1[i], i);
    for (int i=0;i<list2.length;i++) {
        Integer j = map.get(list2[i]);
        if (j != null && i + j <= minSum) {
            if (i + j < minSum) { res = new LinkedList<>(); minSum = i+j; }
            res.add(list2[i]);
        }
    }
    return res.toArray(new String[res.size()]);
}
*/
