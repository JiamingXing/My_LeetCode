package divideConquer;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
	}
	private void helper(List<String> res, String num, StringBuilder sb, int target) {
		if (res.equals("")) {
			if (target == 0) {
				res.add(sb.toString());
			}
			return;
		}
		for (int i = 1; i<= num.length(); i++) {
			String s = num.substring(0, i);
			
		}
	}

}
