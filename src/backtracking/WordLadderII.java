package backtracking;
import java.util.ArrayList;
import java.util.List;
public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		
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
