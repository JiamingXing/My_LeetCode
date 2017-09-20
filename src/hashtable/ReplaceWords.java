package hashtable;

import java.util.List;

//这道题应该用trie来做！
public class ReplaceWords {
	//build trie
	private class TrieNode {
        boolean isPrefix;
        char val;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char val) {
            this.val = val;
        }
    }
	private class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode(' ');
        }
        
        public void insertPrefix(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isPrefix = true;
        }
        
        public String searchPre(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return word;
                } else if (cur.children[c - 'a'].isPrefix) {
                    return word.substring(0, i+1);
                }
                cur = cur.children[c - 'a'];
            }
            return word;
        }
        
    }
	public String replaceWords(List<String> dict, String sentence) {
		Trie trie = new Trie();
        for (String pre : dict) {
            trie.insertPrefix(pre);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            sb.append(trie.searchPre(word)).append(i == words.length - 1 ? "" : " ");
        }
        return sb.toString();
	}
}





//自己写的AC的程序 但是很慢
//时间复杂度O(m*n)
/*
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        int max = 0;
        for (String root : dict) {
            max = Math.max(max, root.length());
        }
        //bucket sort all root
        List<String>[] bucket = new List[max+1];
        for (String root : dict) {
            int len = root.length();
            if (bucket[len] == null) {
                bucket[len] = new ArrayList<>();
            }
            bucket[len].add(root);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean found = false;
            for (int j = 1; j < bucket.length; j++) {
                if (bucket[j] != null) {
                    List<String> cur = bucket[j];
                    for (String root : cur) {
                        if (word.indexOf(root) == 0) {
                            sb.append(root).append(i == words.length - 1 ? "" : " ");
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                sb.append(word).append(i == words.length - 1 ? "" : " ");
            }
        }
        return sb.toString();
    }
}
*/