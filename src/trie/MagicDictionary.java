package trie;
//算是暴力解？O(26m)的search 时间复杂度，每一位的字符用a-z实验
public class MagicDictionary {
	private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    private class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        
        private void insertWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        
        private boolean searchWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }
    }
    
    Trie trie;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.trie = new Trie();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            trie.insertWord(word);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char temp = ch[i];
            for (char c = 'a'; c < 'z'; c++) {
                if (ch[i] == c) {
                    continue;
                }
                ch[i] = c;
                String cur = String.valueOf(ch);
                if (trie.searchWord(cur)) {
                    return true;
                }
                ch[i] = temp;
            }
        }
        return false;
    }
}
