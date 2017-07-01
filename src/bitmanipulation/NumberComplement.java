package bitmanipulation;
//Create a bit mask which has N bits of 1 from RIGHTMOST. 
//In above example, the mask is 111. 
//And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit of 1, 
//left shift one, and then minus one. 
//Please remember this wonderful trick to create bit masks with N ones at RIGHTMOST, 
//you will be able to use it later.
public class NumberComplement {
	public int findComplement(int num) {
		int mask = (Integer.highestOneBit(num) << 1) - 1;
		num = ~ num;
		return num & mask;
//        return num ^ mask;
	}
}
// Integer.highestOneBit returns an int value with at most a single one-bit
// in the position of the highest-order one-bit in the specified int value
// Integer.hightOntBit(int) << 1   左移一位 得到1000...0比int 多一位的

/*
public class NumberComplement {
	public int findComplement(int num) {
		int i = 0;
		int j = 0;
		while (i < num) {
			i += Math.pow(2, j);
			j ++;
		}
		return i - num;
	}
}
*/
