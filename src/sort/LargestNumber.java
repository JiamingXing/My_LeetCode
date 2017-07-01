package sort;

import java.util.Arrays;
import java.util.Comparator;

//Comparator<T> is a functional interface Comparator can be passed to a sort method
//sort(T[] a, Comparator<? super T> C) -> sorts the specified array of objects according to the order induced by the specified comparator.
//我如果改写Comparator 可以自己定义排序规则
public class LargestNumber {
	public String largestNumber(int[] nums) {
		StringBuilder sb = new StringBuilder();
		String[] num = new String[nums.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = nums[i]+"";
		}
		//Comparator 是一个interface 我这里的用法是什么样的？
		Comparator<String> comp = new Comparator<>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		};
		Arrays.sort(num, comp);
		if (num[0].charAt(0) == '0') {
			return "0";
		}
		for (String s : num) {
			sb.append(s);
		}
		return sb.toString();
	}
}
