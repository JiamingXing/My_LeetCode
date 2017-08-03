package string;

import java.util.Arrays;
//需要好好反思一下这道题 因为里面有一些操作你没见到过
//关键是这种medium的题 你要先形成思路 然后才能写出来！ 
//学习这种思路怎么写出来的
//这个就是next permutation的思路 只不过要注意数据类型
public class NextGreaterIII {
	public int nextGreaterElement(int n) {
		//分离int的每一位 不需要去除再取商什么的 转换成char array
		char[] ch = (n + "").toCharArray();
		int i = ch.length - 1;
		//find the first element from right that is greater to its left
		while (i > 0) {
			if (ch[i] > ch[i-1]) {
				break;
			}
			i--;
		}
		if (i == 0) {
			return -1;
		} 
		//find the smallest element larger than ch[i-1]
		char smallest = ch[i-1];
		int k = i; // current smallest
		for (int j = i; j < ch.length; j++) {
			if (ch[j] > smallest && ch[j] <= ch[k]) {
				k = j;
			}
		}
		
		char temp = ch[i-1];
		ch[i-1] = ch[k];
		ch[k] = temp;
		
		// sort the array from i to ch.length - 1;
		Arrays.sort(ch, i, ch.length);
		
		long val = Long.parseLong(String.valueOf(ch));
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;
	}

}
