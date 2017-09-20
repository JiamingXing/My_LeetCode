package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		List<List<String>> res = new ArrayList<>();
		List<String> path = new ArrayList<>();
		Map<String, List<String>> neighbors = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();
		dict.add(beginWord);
		//BFS 用map生成图
		bfs(beginWord, endWord, dict, neighbors, distance);
		//DFS 得到所有最短路径
		dfs(beginWord, endWord, dict, neighbors, distance, res, path);
		return res;
	}
	private void bfs(String start, String end, Set<String> dict, 
			Map<String, List<String>> neighbors, Map<String, Integer> distance) {
		for (String word : dict) {
			neighbors.put(word, new ArrayList<>());
		}
		Queue<String> Q = new LinkedList<>();
		Q.offer(start);
		distance.put(start, 0);
		while (!Q.isEmpty()) {
			int size = Q.size();
			boolean found = false;
			for (int i = 0; i < size; i++) {
				String cur = Q.poll();
				int curDistance = distance.get(cur);
				List<String> curNeighbor = getNextWord(cur, dict);
				for (String neighbor : curNeighbor) {
					neighbors.get(cur).add(neighbor);
					//check if visited with distance
					if (!distance.containsKey(neighbor)) {
						distance.put(neighbor, curDistance+1);
						if (neighbor.equals(end)) {
							found = true;
						} else {
							Q.offer(neighbor);
						}
					}
					if (found) {
						break;
					}
				}
			}
		}
	}
	private List<String> getNextWord(String cur, Set<String> dict) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < cur.length(); i++) {
			for (char c = 'a'; c < 'z'; c++) {
				if (cur.charAt(i) == c) {
					continue;
				}
				String next = replace(cur, c, i);
				if (dict.contains(next)) {
					res.add(next);
				}
			}
		}
		return res;
	}
	private String replace(String cur, char c, int index) {
		char[] ch = cur.toCharArray();
		ch[index] = c;
		return String.valueOf(ch);
	}
	private void dfs(String start, String end, Set<String> dict, 
			Map<String, List<String>> neighbors, Map<String, Integer> distance,
			List<List<String>> res, List<String> path) {
		path.add(start);
		if (start.equals(end)) {
			res.add(new ArrayList<>(path));
			//这个地方加了一个return提前return就会出事情，之前也有一道题犯了这样的错误！
			//应该在后面remove就可以了
			//return;
		} else {
			for (String next : neighbors.get(start)) {
				//neighbor中可能包含了访问过的点
				//没访问过的点的distance必然是cur的distance+1
				if (distance.get(next) == distance.get(start) + 1) {
					dfs(next, end, dict, neighbors, distance, res, path);
//					一开始把remove的语句放在这里 对递归的理解还是不够
//					path.remove(path.size() - 1);
				}
			}
		}
		//DFS当start=end的时候回开始remove path的最上层元素
		path.remove(path.size() - 1);
	}
}


//这样写效率会很低？以为经常有重复的比较在里面
/*
public class WordLadderII {
	int min = 0;
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		if (!wordList.contains(endWord)) {
			return res;
		}
		temp.add(beginWord);
		int len = wordList.size();
		boolean[] tag = new boolean[len];
		helper(res, temp, beginWord, endWord, wordList, tag);
		return res;
	}
	private void helper(List<List<String>> res, List<String> temp, String begin, String end, List<String> wordList, boolean[] tag) {
		//这部分判断是否加到res的代码好长啊 能简短一点吗？
		//endWord一定是最后一个放入的而且endWord在wordList中
		if (comp(temp.get(temp.size()-1), end)) {
			temp.add(end);
			if (min == 0) {
				min = temp.size();
				res.add(new ArrayList<>(temp));
			} else {
				if (temp.size() < min) {
					min = temp.size();
					res.clear();
					res.add(new ArrayList<>(temp));
				} else if (temp.size() == min){
					res.add(new ArrayList<>(temp));
				}
			}
			temp.remove(temp.size() - 1);
			return;
		}
		for (int i = 0; i < wordList.size(); i++) {
			if (tag[i]) {
				continue;
			}
			if (comp(temp.get(temp.size()-1), wordList.get(i))) {
				temp.add(wordList.get(i));
				tag[i] = true;
				helper(res, temp, begin, end, wordList, tag);
				temp.remove(temp.size()-1);
				tag[i] = false;
			}
		}
	}
	private boolean comp(String a, String b) {
		int dif = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				dif ++;
			}
			if (dif > 1) {
				return false;
			}
		}
		if (dif == 0) {
			return false;
		} else {
			return true;
		}
	}
}
*/
