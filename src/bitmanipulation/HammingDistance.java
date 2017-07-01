package bitmanipulation;
// number of positions where the corresponding bits are different
// number of 1's x^y
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}

//public static int bitCount(int i) {
//	 int count = 0;
//	 for (int i = 0; i < 32; i++) {
//		 count += n & 1;
//		 n >>= 1;
//	 }
//	 return count;
//}

/*
int count_one(int n) {
    while(n) {
        n = n&(n-1);
        count++;
    }
    return count;
}
*/
