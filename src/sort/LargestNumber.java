package sort;

import java.util.Arrays;
import java.util.Comparator;

//Comparator<T> is a functional interface Comparator can be passed to a sort method
//sort(T[] a, Comparator<? super T> C) -> sorts the specified array of objects according to the order induced by the specified comparator.
//我如果改写Comparator 可以自己定义排序规则
public class LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		String[] num = new String[nums.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = nums[i]+"";
		}
		//Comparator 是一个interface 我这里的用法是什么样的？
		//这样写不行吗？
//		Comparator<String> comp = new Comparator<>() {
		Comparator<String> comp = new Comparator<String>() {
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


/*
public class LargestNumber {
    private class Comp implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str2.compareTo(str1);
        }
    }
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
		String[] num = new String[nums.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = nums[i]+"";
		}
        Comp x = new Comp();
		//Comparator 是一个interface 我这里的用法是什么样的？
		// Comparator<String> comp = new Comparator<String>() {
		// 	@Override
		// 	public int compare(String str1, String str2) {
		// 		String s1 = str1 + str2;
		// 		String s2 = str2 + str1;
		// 		return s2.compareTo(s1);
		// 	}
		// };
		// Arrays.sort(num, comp);
        Arrays.sort(num, x);
		if (num[0].charAt(0) == '0') {
			return "0";
		}
		for (String s : num) {
			sb.append(s);
		}
		return sb.toString();
    }
}
*/

