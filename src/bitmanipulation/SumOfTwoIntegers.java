package bitmanipulation;
//不知道这个思路是怎么想出来的。。
public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		return b == 0 ? a : getSum(a^b, (a&b) << 1);
	}
}
