package review;

import java.util.HashSet;
import java.util.Set;
//10ms
public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
		Set<Character> set = new HashSet<>();
		String vowels = "aeiouAEIOU";
		char[] vowChar = vowels.toCharArray();
		for (int i = 0; i < vowChar.length; i++) {
			set.add(vowChar[i]);
		}
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
		for (int i = 0, j = ch.length -1; i < j; i++, j-- ) {
			while (i < j && !set.contains(ch[i])) {
				i ++;
			}
			while (i < j && !set.contains(ch[j])) {
				j--;
			}
			swap(ch, i, j);
		}
		return String.valueOf(ch);
	}
	private void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
}

//6ms
/*
public class Solution {
static final String vowels = "aeiouAEIOU";
public String reverseVowels(String s) {
    int first = 0, last = s.length() - 1;
    char[] array = s.toCharArray();
    while(first < last){
        while(first < last && vowels.indexOf(array[first]) == -1){
            first++;
        }
        while(first < last && vowels.indexOf(array[last]) == -1){
            last--;
        }
        char temp = array[first];
        array[first] = array[last];
        array[last] = temp;
        first++;
        last--;
    }
    return new String(array);
}
*/