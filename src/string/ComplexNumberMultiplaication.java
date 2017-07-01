package string;

public class ComplexNumberMultiplaication {
	public String complexNumberMultiply(String a, String b) {
		String[] sta = a.split("\\+");
		String[] stb = b.split("\\+");
		//split的时候错了 为什么要加\\？
//		String[] sta = a.split("+");
//		String[] stb = b.split("+");
		int realA = Integer.parseInt(sta[0]);
		int realB = Integer.parseInt(stb[0]);
		int compA = Integer.parseInt(sta[1].replace("i", ""));
		int compB = Integer.parseInt(stb[1].replace("i", ""));
		// real part and complex part of result
		int realRes = realA * realB - compA * compB;
		int compRes = realA * compB + realB * compA;
		StringBuilder sb = new StringBuilder();
		if (realRes < 0) {
			sb.append('-');
		}
		sb.append(Math.abs(realRes)).append('+');
		if (compRes < 0) {
			sb.append('-');
		}
		sb.append(Math.abs(compRes)).append('i');
		return sb.toString();
	}

}
//别人的三行程序
/*
public String complexNumberMultiply(String a, String b) {
    int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(), 
          coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
    return (coefs1[0]*coefs2[0] - coefs1[1]*coefs2[1]) + "+" + (coefs1[0]*coefs2[1] + coefs1[1]*coefs2[0]) + "i";
}
*/