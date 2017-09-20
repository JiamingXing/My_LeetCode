package math;
//trailing 0 意思是尾部的0 尾部的0取决于5和2因子的个数
//一个5和一个2就是一个0，而且在阶乘中，2永远是足够的 所以只要看阶乘中有多少个5的因子就行了
public class FactorialTralingZeros {
	public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
