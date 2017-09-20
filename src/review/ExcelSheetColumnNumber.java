package review;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int tag = 1;
        int res = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            res += (c[i] - 'A' + 1) * tag;
            tag *= 26;
        }
        return res;
    }
}
