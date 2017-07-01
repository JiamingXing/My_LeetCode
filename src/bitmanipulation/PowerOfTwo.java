package bitmanipulation;
//判断是不是2的power就是确定二进制是不是只有一个1，而且在最高位上
//我们只要和-1的数想与看是不是0就OK了因为-1的数必然是011...1的形式
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && Integer.bitCount(n) == 1;
		//return ((n & (n-1)) == 0 && n > 0);
	}
}
