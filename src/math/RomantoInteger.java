package math;

public class RomantoInteger {
	public int romanToInt(String s) {
		int index = 0;
		int res = 0;
		while (index < s.length()) {
			if (s.charAt(index) == 'M') {
				int countM = 1;
				while (index < s.length() && s.charAt(index+1) == 'M') {
					countM ++;
					index ++;
				}
				res += countM * 1000;
				index ++;
			}
			
		}
	}
}

/*
public static int romanToInt(String s) {
	int res = 0;
	for (int i = s.length() - 1; i >= 0; i--) {
		char c = s.charAt(i);
		switch (c) {
		case 'I':
			res += (res >= 5 ? -1 : 1);
			break;
		case 'V':
			res += 5;
			break;
		case 'X':
			res += 10 * (res >= 50 ? -1 : 1);
			break;
		case 'L':
			res += 50;
			break;
		case 'C':
			res += 100 * (res >= 500 ? -1 : 1);
			break;
		case 'D':
			res += 500;
			break;
		case 'M':
			res += 1000;
			break;
		}
	}
	return res;
}
*/
