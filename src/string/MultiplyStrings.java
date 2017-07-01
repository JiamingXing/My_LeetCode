package string;
//如何规避溢出
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int mult1 = Integer.parseInt(num1);
		int tag = 0;
		int res = 0;
		int firstNoneZero = -1;
		for (int i = num2.length()-1; i >= 0; i--) {
			if (firstNoneZero != 1 && num2.charAt(i) == '0') {
				tag ++;
			}
			firstNoneZero = 1;
			res += mult1 * Character.getNumericValue(num2.charAt(i)) * Math.pow(10, tag);
			tag++;
		}
		return "" + res;
	}

}
