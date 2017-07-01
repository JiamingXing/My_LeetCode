package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LettersCombiantionOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		Map<Integer, String> map = new HashMap<>();
		List<String> res = new ArrayList<>();
		//一开始又没考虑这种空的情况 反思一下啊！！
		if (digits.equals("")) {
            return res;
        }
		map.put(0, "");
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		helper(res, map, digits, "", 0);
		return res;
	}
	private void helper(List<String> res, Map<Integer, String> map, String digits, String s, int pos) {
		if (s.length() == digits.length()) {
			res.add(s);
			return;
		}
		int n = Character.getNumericValue(digits.charAt(pos));
		String st = map.get(n);
		for (int j = 0; j < st.length(); j++) {
			String ss = String.valueOf(st.charAt(j));
			helper(res, map, digits, s+ss, pos+1);
		}	
	}

}



/*
public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        while(ans.peek().length()==i){
            String t = ans.remove();
            for(char s : mapping[x].toCharArray())
                ans.add(t+s);
        }
    }
    return ans;
}
*/