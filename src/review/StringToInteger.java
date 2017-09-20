package review;
//自己想想有哪些test case 测试下思维的严密性
public class StringToInteger {
	public int myAtoi(String str) {
		if (str.length() == 0) {
			return 0;
		}
		int index = 0;
		int sign = 1;
		int res = 0;
		//2. Remove Spaces
//		while(str.charAt(index) == ' ' && index < str.length())
//		index ++;
//
//		can be replaced by str = str.trim();
		while (index < str.length() && str.charAt(index) == ' ') {
			index ++;
		}
		//要先判断符号 如果正负的问题
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
		}
		while (index < str.length()) {
			int cur = str.charAt(index) - '0';
			if (cur < 0 || cur >= 10) {
				break;
			}
			if (Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE % 10 < cur) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + cur;
			index ++;
		} 
		return res * sign;
	}
}
