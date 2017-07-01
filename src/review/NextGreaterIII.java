package review;

import java.util.Arrays;

public class NextGreaterIII {
	public int nextGreaterElement(int n) {
		char[] number = (n+"").toCharArray();
		int i = number.length - 1;
		while (i > 0) {
			if (number[i] > number[i-1]) {
				break;
			}
			i --;
		}
		if (i == 0) {
			return -1;
		}
		// find next greater of number[i-1]
		char smallest = number[i-1];
		int nextIndex = i;
		for (int j = i; j < number.length; j++) {
			if (number[j] > smallest) {
				nextIndex = j;
			}
		}
		char temp = number[nextIndex];
		number[nextIndex] = number[i-1];
		number[i-1] = temp;
		Arrays.sort(number, i, number.length);
		long val = Long.parseLong(String.valueOf(number));
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;
	}
}
