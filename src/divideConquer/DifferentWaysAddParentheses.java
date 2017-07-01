package divideConquer;
import java.util.ArrayList;
//output all possible results 如何考虑所有的情况
import java.util.List;

//问题在于 首先给你的是一个String如何转换成 计算int的式子
//另外就是如何partition
//我自己没有想出这道题 但是我觉得这道题你应该想得出来 心态不要急躁
//好好想想 这一类的题怎么做？
public class DifferentWaysAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				String former = input.substring(0, i);
				String latter = input.substring(i + 1);
				List<Integer> listF = diffWaysToCompute(former);
				List<Integer> listL = diffWaysToCompute(latter);
				for (int f : listF) {
					for (int l : listL) {
						if (c == '+') {
							res.add(f + l);
						}
						if (c == '-') {
							res.add(f - l);
						}
						if (c == '*') {
							res.add(f * l);
						}
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.parseInt(input));
		}
		return res;
	}

}
