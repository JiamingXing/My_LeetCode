package review;
//相当于26进制数的转换 A-Z
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
        	n --;
            int temp = n % 26;
            //把int cast成char
            //这里是insert 不是append
            sb.insert(0, (char)('A' + temp));
            n = n/26;
        }
        return sb.toString();
        //一行代码可以搞定
        //return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
