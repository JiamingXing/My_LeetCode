package backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		HashMap<Integer, HashSet<Character>> row = new HashMap<>();
		HashMap<Integer, HashSet<Character>> col = new HashMap<>();
		HashMap<Integer, HashSet<Character>> mod = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			row.put(i, new HashSet<Character>());
			col.put(i, new HashSet<Character>());
			mod.put(i, new HashSet<Character>());
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char cur = board[i][j];
				if (cur != '.' && !row.get(i).add(cur)) {
					return false;
				}
				if (cur != '.' && !col.get(j).add(cur)) {
					return false;
				}
				int curMod = (i/3) * 3 + j/3;
				if (cur != '.' && !mod.get(curMod).add(cur)) {
					return false;
				}
			}
		}
		return true;
	}
}
