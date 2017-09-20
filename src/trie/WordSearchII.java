package trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	private class TrieNode {
        String curWord;
        TrieNode[] children = new TrieNode[26];
    }
    private class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        
        public void insertWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.curWord = word;
        }
    }
	private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                helper(board, res, trie.root, visited, i, j);
            }
        }
        return res;
	}
	private void helper(char[][] board, List<String> res, TrieNode cur, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }
        char c = board[i][j];
        if (cur.children[c - 'a'] == null) {
            return;
        } else if (cur.children[c - 'a'].curWord != null){
            res.add(cur.children[c - 'a'].curWord);
            //de-duplicate
            cur.children[c - 'a'].curWord = null;
        }
        visited[i][j] = true;
        cur = cur.children[c - 'a'];
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            helper(board, res, cur, visited, row, col);
        }
        visited[i][j] = false;
    }
}
