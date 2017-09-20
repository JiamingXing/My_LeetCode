package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		if (strs == null || strs.length == 0) {
			return res;
		}
		for (String s : strs) {
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			if (!map.containsKey(String.valueOf(temp))) {
				map.put(String.valueOf(temp), new ArrayList<>());
			}
			map.get(String.valueOf(temp)).add(s);
		}
		//从来没用过这样的写法 所以很陌生 而且不是自己的思路所以没有总结复习的话 根本想不起来
		//map.values() 返回的是一个collection collection是java中一个大的interface
		//想一想为什么可以这样写，把一个collection作为Arraylist的内容，arraylist实现了collection这个接口
		return new ArrayList<>(map.values());
	}
}



// sort the map bucket
//public class GroupAnagrams {
//	public List<List<String>> groupAnagrams(String[] strs) {
//		if(strs==null || strs.length == 0){
//			return new ArrayList<List<String>>();
//		}
//		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
//		//Arrays.sort(strs);
//		for (String s:strs) {
//			char[] ca = s.toCharArray();
//			Arrays.sort(ca);
//			String keyStr = String.valueOf(ca);
//			if(!map.containsKey(keyStr))
//				map.put(keyStr, new ArrayList<String>());
//			map.get(keyStr).add(s);
//		}
//		
//		for(String key: map.keySet()) {
//			Collections.sort(map.get(key));
//		}
//		return new ArrayList<List<String>>(map.values());
//	}
//}
