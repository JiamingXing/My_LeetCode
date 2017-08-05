package backtracking;
//shortest length
//这道题如果知道tag是BFS的话，那我们对于一个word我们先考虑他所有的ladder word

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//这道题的本质可以看成graph 
//这种题就是非常典型的BFS
//类似的如果碰到这种单词变换的题 给你一定的单词变换规则 很可能是BFS
public class WordLadderI {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		if (beginWord.equals(endWord)) {
			return 1;
		}
		Queue<String> Q = new LinkedList<>();
		//图的BFS就需要一个hash table
		HashSet<String> visited = new HashSet<>();
		Q.offer(beginWord);
		visited.add(beginWord);
		int len = 1;
		while (!Q.isEmpty()) {
			len ++;
			//我需要这层循环吗？
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				String cur = Q.poll();
				for (int j = 0; j < cur.length(); j++) {
					char[] chs = cur.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (chs[j] == c) {
							continue;
						}
						chs[j] = c;
						String target = String.valueOf(chs);
						if (target.equals(endWord)) {
							return len;
						}
						if (visited.contains(target)) {
							continue;
						}
						if (wordList.contains(target)) {
							Q.offer(target);
							visited.add(target);
						}
					}
				}
			}
		}
		return 0;
	}
}

//AC
/*
public class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        
        if (start.equals(end)) {
            return 1;
        }
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        hash.add(start);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
*/

/*
public class WordLadderI {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> Q = new LinkedList<>();
		Q.add(beginWord);
		//null 用来计数ladder的长度
		Q.add(null);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int level = 1;
		while (!Q.isEmpty()) {
			String cur = Q.poll();
			if (cur != null) {
				for (int i = 0; i < cur.length(); i++) {
					char[] chs = cur.toCharArray();
					//用更换一位字符的方法和在字典中逐个比较的方法相比，这个方法的时间复杂度是固定的26l
					//l是每个word的长度 这样会快很多
					for (char c = 'a'; c <= 'z'; c++) {
						chs[i] = c;
						String target = String.valueOf(chs);
						if (target.equals(endWord)) {
							return level + 1;
						}
						//先找到当前这个单词对应的所有dif at one character的单词
						if (wordList.contains(target) && !visited.contains(target)) {
							Q.add(target);
							visited.add(target);
						}
					}
				}
			} else {
				level ++;
				//如果碰到了null 说明breadth加一 而剩下的Q非空说明有下一层存在我们再加一个null
				if (!Q.isEmpty()) {
					Q.add(null);
				}
			}
		}
		return 0;
	}
}
*/


/*
public class WordLadderI {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		int len = 1;
		HashSet<String> visited = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}
			Set<String> temp = new HashSet<>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();
				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c < 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);
						if (endSet.contains(target)) {
							return len+1;
						}
						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}
			beginSet = temp;
			len ++;
		}
		return 0;
	}
}
*/