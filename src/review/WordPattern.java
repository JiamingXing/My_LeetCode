package review;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		String[] st = str.split(" ");
		if (pattern.length() != st.length) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(st[i])) {
					return false;
				}
			} else if (map.containsValue(st[i])) {
				return false;
			}
			map.put(c, st[i]);
		}
		return true;
	}

}
