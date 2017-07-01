package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//这是最简单的思路 也比较慢
public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String st = s.substring(i, i+10);
			map.put(st, map.getOrDefault(st, 0) + 1);
		}
		List<String> result = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) > 1) {
				result.add(key);
			}
		}
		return result;
	}
}

//hash map + bit manipulation 会快一些
/*
public List<String> findRepeatedDnaSequences(String s) {
    Set<Integer> words = new HashSet<>();
    Set<Integer> doubleWords = new HashSet<>();
    List<String> rv = new ArrayList<>();
    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    for(int i = 0; i < s.length() - 9; i++) {
        int v = 0;
        for(int j = i; j < i + 10; j++) {
            v <<= 2;
            v |= map[s.charAt(j) - 'A'];
        }
        if(!words.add(v) && doubleWords.add(v)) {
            rv.add(s.substring(i, i + 10));
        }
    }
    return rv;
}
*/
