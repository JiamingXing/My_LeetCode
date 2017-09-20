package review;

public class PowXN {
	public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
        	//n = Integer.MIN的话 如果变成-n会overflow 所以要特殊处理一下
            if (n == Integer.MIN_VALUE) {
                return 1.0/ (myPow(x, Integer.MAX_VALUE) * x);
            }
            n = -n;
            x = 1/x;
        }
        return (n % 2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
