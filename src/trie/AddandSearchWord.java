package trie;

public class AddandSearchWord {
	private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String curWord = "";
    }
    private class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        public void insertWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.curWord = word;
        }
    }
    
    Trie trie;
    
    /** Initialize your data structure here. */
    public AddandSearchWord() {
        this.trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insertWord(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), trie.root, 0);
    }
    
    private boolean match(char[] ch, TrieNode node, int k) {
        if (k == ch.length) {
            return !node.curWord.equals("");
        }
        if (ch[k] != '.') {
            return node.children[ch[k] - 'a'] != null && match(ch, node.children[ch[k] - 'a'], k+1);
        } else {
            for (int i = 0; i < 26; i++) {
            	if (node.children[i] != null && match(ch, node.children[i], k+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
