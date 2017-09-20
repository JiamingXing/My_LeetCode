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

//DFS
/*
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }
        String[] table = new String[]{" ", " ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits, 0, table, "", res);
        return res;
    }
    private void helper(String digits, int pos, String[] table, String cur, List<String> res) {
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
        int num = Character.getNumericValue(digits.charAt(pos));
        String temp = table[num];
        for (int i = 0; i < temp.length(); i++) {
            helper(digits, pos+1, table, cur + temp.charAt(i), res);
        }
    }
}
*/

//这种解法可以理解为BFS 对应上面的backtracking是DFS的解法
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

//这里有一个错误的写法
class Solution {
    public List<String> letterCombinations(String digits) {
    	//这里如果使用LinkedList实现List而不是用LinkedList会出问题
    	//因为LinkedList这个类是implements了Queue这个接口的
  		//Queue里面的remove() peek()这些方法linkedlist继承了 但是List并不实现Queue
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] table = new String[]{"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String cur = res.remove();
                for (char c : table[index].toCharArray()) {
                    res.add(cur + c);
                }
            }
        }
        return res;
    }
}

*/