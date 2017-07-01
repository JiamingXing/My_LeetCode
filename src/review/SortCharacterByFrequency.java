package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//字符的hashtable用数组就可以完成了没必要用hashtable
public class SortCharacterByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
			max = Math.max(max, map.get(c));
		}
		//List<Character>[] list = new ArrayList<>[max+1] ?
		List<Character>[] list = new ArrayList[max+1];
		StringBuilder sb = new StringBuilder();
		for (char key : map.keySet()) {
			int temp = map.get(key);
			if (list[temp] == null) {
				list[temp] = new ArrayList<>();
			}
			list[temp].add(key);
		}
		for (int i = list.length-1; i > 0; i--) {
			List<Character> l = list[i];
			if (l == null) {
				continue;
			}
			for (char ch : l) {
				for (int j = 0; j < i; j++) {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
}

//bucket sort?
/*
public String frequencySort(String s) {
    if(s.length() < 3)
        return s;
    int max = 0;
    int[] map = new int[256];
    for(char ch : s.toCharArray()) {
        map[ch]++;
        max = Math.max(max,map[ch]);
    }
    String[] buckets = new String[max + 1]; // create max buckets
    for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
        String str = buckets[map[i]];
        if(map[i] > 0)
            buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
    }
    StringBuilder strb = new StringBuilder();
    for(int i = max; i >= 0; i--) { // create string for each bucket.
        if(buckets[i] != null)
            for(char ch : buckets[i].toCharArray())
                for(int j = 0; j < i; j++)
                    strb.append(ch);
    }
    return strb.toString();
}
*/
