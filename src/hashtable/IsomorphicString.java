package hashtable;

import java.util.HashMap;
import java.util.Map;
//这个做法是错的 但是不知道最后一个没通过的case 错在哪里
public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			if(map1.containsKey(s.charAt(i)) && map2.containsKey(t.charAt(i))){
				if(map1.get(s.charAt(i)) != map2.get(t.charAt(i))){
					return false;
				}else{
					map1.put(s.charAt(i), i);
					map2.put(t.charAt(i), i);
				}
			}else if (!map1.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))){
				map1.put(s.charAt(i), i);
				map2.put(t.charAt(i), i);
			}else {
				return false;
			}
		}
		return true;
	}

}

//这是后来自己做的正确的思路
/*
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) != t.charAt(i)) {
					return false;
				}
				//注意要考虑进去这种情况 下面这个else if
			} else if (map.containsValue(t.charAt(i))) {
				return false;
			}
			map.put(c, t.charAt(i));
		}
		return true;
	}

}
*/

