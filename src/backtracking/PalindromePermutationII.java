package backtracking;
//排好一边
//这道题完完整整自己写出来的！
//代码可以再简化一些。。 主要在处理奇数长度的permutation的时候 可以简化
import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> temp = new ArrayList<>();
		List<String> res = new ArrayList<>();
		List<Character> leftHalf = new ArrayList<>();
		int[] hash = new int[256];
		for (int i = 0; i < s.length(); i++) {
			hash[s.charAt(i)] ++;
		}
		int tag = 0;
		char odd = 'a';
		//add all permutation char at left half string
		for (int i = 0; i < 256; i++) {
			if (hash[i] % 2 == 1) {
				if (tag == 0) {
					tag = 1;
					odd = (char) i;
				} else {
					return res;
				}
			}
			hash[i] = hash[i] / 2;
			for (int j = 0; j < hash[i]; j++) {
				leftHalf.add((char) i);
			}
		}
		//
		boolean[] visited = new boolean[leftHalf.size()];
		helper(temp, leftHalf, visited, new StringBuilder());
		//if odd len add the center char
		if (tag == 1) {
			for (int i = 0; i < temp.size(); i++) {
				StringBuilder sb = new StringBuilder(temp.get(i));
				sb.append(odd);
				temp.set(i, sb.toString());
			}
		}
		//mirror all result at temp and put into res
		mirror(temp, res, tag);
		return res;
	}
	private void helper(List<String> temp, List<Character> cur, boolean[] visited, StringBuilder sb) {
		if (sb.length() == cur.size()) {
			temp.add(sb.toString());
			return;
		}
		for (int i = 0; i < cur.size(); i++) {
			if (visited[i] || i > 0 && cur.get(i) == cur.get(i-1) && !visited[i-1]) {
				continue;
			}
			int len = sb.length();
			sb.append(cur.get(i));
			visited[i] = true;
			helper(temp, cur, visited, sb);
			sb.setLength(len);
			visited[i] = false;
		}
	}
	private void mirror(List<String> temp, List<String> res, int tag) {
		for (String cur : temp) {
			StringBuilder sb = new StringBuilder(cur);
			for (int i = tag == 1 ? cur.length() - 2 : cur.length() - 1; i >= 0; i--) {
				sb.append(cur.charAt(i));
			}
			res.add(sb.toString());
		}
	}
}


//别人的代码
/*
public List<String> generatePalindromes(String s) {
    int odd = 0;
    String mid = "";
    List<String> res = new ArrayList<>();
    List<Character> list = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();

    // step 1. build character count map and count odds
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        odd += map.get(c) % 2 != 0 ? 1 : -1;
    }

    // cannot form any palindromic string
    if (odd > 1) return res;

    // step 2. add half count of each character to list
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        char key = entry.getKey();
        int val = entry.getValue();

        if (val % 2 != 0) mid += key;

        for (int i = 0; i < val / 2; i++) list.add(key);
    }

    // step 3. generate all the permutations
    getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

    return res;
}

// generate all unique permutation from list
void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
    if (sb.length() == list.size()) {
        // form the palindromic string
        res.add(sb.toString() + mid + sb.reverse().toString());
        sb.reverse();
        return;
    }

    for (int i = 0; i < list.size(); i++) {
        // avoid duplication
        if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

        if (!used[i]) {
            used[i] = true; sb.append(list.get(i));
            // recursion
            getPerm(list, mid, used, sb, res);
            // backtracking
            used[i] = false; sb.deleteCharAt(sb.length() - 1);
        }
    }
}
*/
