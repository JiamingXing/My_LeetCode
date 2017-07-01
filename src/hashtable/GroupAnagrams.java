package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//其实主要还是考察string的操作
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			//返回值应该是list 那么这么写Arraylist为什么可以 不应该new一个？
			return new ArrayList<List<String>>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			//char array sort没用过
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String key = String.valueOf(temp);
			if (!map.containsKey(key)) {
				// list arraylist
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}
		//map.value 从没用过
		return new ArrayList<List<String>>(map.values());
	}
}





/*
//sort list of each hash map bucket will be faster than sorting array
public List<List<String>> groupAnagrams(String[] strs) {
	if(strs==null || strs.length == 0){
		return new ArrayList<List<String>>();
	}
	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	//Arrays.sort(strs);
	for (String s:strs) {
		char[] ca = s.toCharArray();
		Arrays.sort(ca);
		String keyStr = String.valueOf(ca);
		if(!map.containsKey(keyStr))
			map.put(keyStr, new ArrayList<String>());
		map.get(keyStr).add(s);
	}
	
	for(String key: map.keySet()) {
		Collections.sort(map.get(key));
	}
	return new ArrayList<List<String>>(map.values());
}
*/
