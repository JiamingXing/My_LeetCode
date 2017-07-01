package stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int length = num.length() - k;
		int mostLeft = length - 1;
		//cur = -1开始 保证下面 cur+1从0开始
		int cur = -1;
		char[] ch = num.toCharArray();
		char[] res = new char[length];
		for (int i = 0; i < res.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = cur + 1; j < ch.length - mostLeft; j++) {
				if (ch[j] <min) {
					min = ch[j];
					cur = j;
				}
			}
			mostLeft --;
			res[i] = ch[cur];
		}
		//搞定lead zero
		//有case 因为数字过长没通过。。。。。。。。。。
		//这样写 只适用于位数少的number 还是学习别人的思路吧
		int temp = Integer.parseInt(String.valueOf(res));
		return "" + temp;
	}

}



/*
public String removeKdigits(String num, int k) {
	int length = num.length() - k;
	char[] res = new char[num.length()];
	int top = 0;
	for (int i = 0; i < num.length(); i++) {
		char c = num.charAt(i);
		while (top > 0 && res[top - 1] > c && k > 0) {
			top --;
			k--;
		}
		res[top++] = c;
	}
	int idx = 0;
	while (idx < length && res[idx] == '0') {
		idx ++;
	}
	return idx == length ? "0" : new String(res, idx, length - idx);
}

}
*/
