package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
	public String reverseVowels(String s) {
		Set<Character> set = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
//		Set<Character> set = new HashSet<>();
//		set.add('a');
//		set.add('e');
//		set.add('i');
//		set.add('o');
//		set.add('u');
//		set.add('A');
//		set.add('E');
//		set.add('I');
//		set.add('O');
//		set.add('U');
		char[] ch = s.toCharArray();
		for (int i = 0, j = ch.length; i < j; i++, j-- ) {
			while (i < j && !set.contains(ch[i])) {
				i ++;
			}
			while (i < j && !set.contains(ch[j])) {
				j--;
			}
			swap(ch, i, j);
		}
		//char array转换成String的时候要用String.valueOf
//		return ch.toString();
		return String.valueOf(ch);
	}
	private void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

}
