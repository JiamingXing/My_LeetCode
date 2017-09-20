package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//这道题的关键点在于：我无论用map还是array都可以one-pass计算
//所有character的个数
//但是如何根据这个value进行排序还能找到对应的key？
/*
public class SortCharactersByFre {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		//List<Character>[] array = new List[count + 1];
		//用arraylist 来显现list的时候可以设定长度吗
		List<List<Character>> list = new ArrayList<>();
		for (Character cha : map.keySet()) {
			
		}
	}

}
*/
//bucket sort一种很方便简单的方法
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


//一开始的思路行不通 就要变通 这道题用TreeMap来做
public class SortCharactersByFre {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			max = Math.max(max, map.get(s.charAt(i)));
		}
		List<Character>[] temp = new List[max + 1];
//		List<Character>[] temp = new List<Character>[max + 1];
//		ArrayList<ArrayList<Character>> list = new ArrayList<>();
		for (char key : map.keySet()) {
			int count = map.get(key);
			if (temp[count] == null) {
				temp[count] = new ArrayList<>();
			}
			temp[count].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = temp.length - 1; i >= 0; i--) {
			if (temp[i] != null) {
				for (int j = 0; j < temp[i].size(); j++) {
					for (int k = 0; k < i; k ++) {
						sb.append(temp[i].get(j));
					}
				}
			}
		}
		return sb.toString();
	}

}

//复习的时候写的 Memory Limit Exceeded
/*
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        List<Character>[] bucket = new List[max + 1];
        // List<Character>[] bucket = new List<Character>[max + 1];
        for (char c : map.keySet()) {
            int cur = map.get(c);
            if (bucket[cur] == null) {
                bucket[cur] = new ArrayList<>();
            }
            bucket[cur].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 1; i --) {
            if (bucket[i] != null) {
                List<Character> cur = bucket[i];
                for (char c : cur) {
                    int repeatTime = i;
                    while (repeatTime > 0) {
                        sb.append(c);
                        repeatTime --;
                    }
                }
            }
        }
        return sb.toString();
    }
}
*/




//答案的做法 对list的实现不熟悉
//还有string builder
/*
public String frequencySort(String s) {
    if (s == null) {
        return null;
    }
    Map<Character, Integer> map = new HashMap();
    char[] charArray = s.toCharArray();
    int max = 0;
    for (Character c : charArray) {
        if (!map.containsKey(c)) {
            map.put(c, 0);
        }
        map.put(c, map.get(c) + 1);
        max = Math.max(max, map.get(c));
    }

    List<Character>[] array = buildArray(map, max);

    return buildString(array);
}

private List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
    List<Character>[] array = new List[maxCount + 1];
    for (Character c : map.keySet()) {
        int count = map.get(c);
        if (array[count] == null) {
            array[count] = new ArrayList();
        }
        array[count].add(c);
    }
    return array;
}

private String buildString(List<Character>[] array) {
    StringBuilder sb = new StringBuilder();
    for (int i = array.length - 1; i > 0; i--) {
        List<Character> list = array[i];
        if (list != null) {
            for (Character c : list) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
    }
    return sb.toString();
}
*/





/*
public class Solution {
    public String frequencySort(String s) {
        int[] freq = new int [256];
        for (char ch: s.toCharArray()) freq[ch]++;
        TreeMap<Integer, List<Character>> tree = new TreeMap<Integer, List<Character>>();
        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (!tree.containsKey(freq[i])) {
                    tree.put(freq[i], new LinkedList<Character>());
                }
                tree.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(tree.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch: entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }
        return sb.toString();
    }
}
*/
