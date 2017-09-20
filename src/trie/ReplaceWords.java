package trie;

import java.util.List;

public class ReplaceWords {
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
