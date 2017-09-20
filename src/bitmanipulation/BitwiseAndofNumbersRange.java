package bitmanipulation;
//看最后一位只要有0就必然And出0
//然后我们可以用这个思路不断地右移
public class BitwiseAndofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
	}
}
