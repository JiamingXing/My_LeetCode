package bitmanipulation;

public class NumberOf1Bits {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n >>>= 1;
		}
		return count;
	}
}

//下面这种方法只适用 有符号的？
/*
public int hammingWeight(int n) {
    int count = 0;
	while (n > 0) {
		n = n & (n-1);
		count ++;
	}
	return count;
}
*/
